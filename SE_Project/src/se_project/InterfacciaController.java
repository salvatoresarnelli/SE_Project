/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import se_project.parser.UserDefinedOperationParser;
import se_project.parser.ParserString;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import other.OperationSet;
import other.VariableSet;
import se_project.commands.OperationCommand;
import se_project.commands.userDefinedOperations.ExecuteUserDefinedOperationCommand;
import se_project.commands.variablesCommands.DiffVariableCommand;
import se_project.exceptions.OperationNotFoundException;
import se_project.commands.variablesCommands.NewVariableCommand;
import se_project.commands.variablesCommands.OverrideVariableCommand;
import se_project.commands.variablesCommands.SumVariableCommand;
import se_project.commands.variablesCommands.VariableCommand;
import se_project.exceptions.CollisionException;
import se_project.exceptions.DivisionByZeroException;
import se_project.exceptions.EmptyStackException;
import se_project.exceptions.ExistingNameException;
import se_project.exceptions.InvalidNumberException;
import se_project.exceptions.InvalidOperationException;
import se_project.exceptions.InvalidVariableNameException;
import se_project.exceptions.NonExistingVariable;
import se_project.exceptions.NotApplicableOperation;
import se_project.exceptions.UndefinedPhaseException;
import se_project.exceptions.VariableExistingException;
import se_project.parser.ComplexNumberParser;
import se_project.parser.OperationParser;
import se_project.parser.StackOperationParser;
import se_project.parser.VariableParser;

/**
 * FXML Controller class
 *
 * @author emanu
 */
public class InterfacciaController implements Initializable {

    /*Vengono definite una linked list contenente i comandi passati precedentemente
    nella casella di testo, un indice contenente l'indice attuale della lista e un 
    list iterator per iterare tale lista.*/
    LinkedList<String> prevs;
    int index = 0;
    ListIterator<String> it;

    @FXML
    private TextField inputField;
    @FXML
    private Button buttonPush;
    @FXML
    private ListView<ComplexNumber> listView;
    private final Solver solver = Solver.getInstance();
    private final VariableParser variableParser = new VariableParser(new StackOperationParser(new OperationParser(new ComplexNumberParser(new ParserString()))));
    private final UserDefinedOperationParser decoratorParserOperation = new UserDefinedOperationParser(variableParser);
    private VariablesStack variablesStack;
    private ObservableList<ComplexNumber> observableList;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    private Button variablesHandler;

    private ObservableList<VariableSet> variablesList;
    private ObservableList<OperationSet> operationsList;
    OperationDict operationDict = OperationDict.getInstance();
    private VBox box;
    @FXML
    private HBox hbox;
    @FXML
    private MenuItem buttonClear;
    @FXML
    private MenuItem buttonDrop;
    @FXML
    private MenuItem buttonDuplicate;
    @FXML
    private MenuItem buttonSwap;
    @FXML
    private MenuItem buttonOver;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //caricamento della barra laterale(menù)
        try {
            box = FXMLLoader.load(getClass().getResource("sidePane.fxml"));
        } catch (IOException ex) {
            alert("unable to reach sidepane.fxml", "", "");
        }
        for (Node n : box.getChildren()) {
            if (n.getAccessibleText() != null) {
                n.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {

                    try {
                        switch (n.getAccessibleText()) {

                            case "home":
                                Node homePage = FXMLLoader.load(getClass().getResource("calculator.fxml"));
                                hbox.getChildren().setAll(homePage);
                                break;
                            case "Salva Funzione":
                                this.saveFunctions();
                                break;

                            case "Carica Funzione":
                                this.uploadFunctions();
                                break;

                            case "Gestione Operazioni":

                                Node opManager = FXMLLoader.load(getClass().getResource("OperationsManager.fxml"));
                                hbox.getChildren().setAll(opManager);
                                break;

                            case "Gestione Variabili":
                                Node varManager = FXMLLoader.load(getClass().getResource("VariablesManager.fxml"));
                                hbox.getChildren().setAll(varManager);
                                break;

                        }
                    } catch (IOException ee) {
                        System.out.println("Error");
                    }
                });
            }
        }
        //viene definita la transizione del button "hamburger".
        HamburgerBasicCloseTransition transition = new HamburgerBasicCloseTransition(hamburger);
        //alla pressione viene effettuata una transizione.
        transition.setRate(-1);
        //viene impostata la scena caricata come pannello laterale del menù a scomparsa.
        drawer.setSidePane(box);
        //menù a scomparsa inizialmente invisibile.
        drawer.setVisible(false);
        //sulla pressione dell'hamburger
        hamburger.setOnMouseClicked(event -> {
            //viene effettuata la transizione.
            transition.setRate(transition.getRate() * -1);
            transition.play();
            if (!drawer.isOpened()) {
                //se il menù laterale è chiuso, viene reso visibile e aperto.
                drawer.setVisible(true);
                drawer.open();

            } else {
                //se è aperto, viene chiuso e reso invisibile al termine della chiusura.
                drawer.close();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        drawer.setVisible(false);
                    }
                });

            }
        });
        /*si inizilizzano lista e iteratore*/
        prevs = new LinkedList<>();
        it = prevs.listIterator();
        //si inizializza una observable list, associata allo stack.
        observableList = FXCollections.observableArrayList();
        /*si definisce che 
            o alla pressione del tasto enter, si deve leggere il contenuto della 
              casella di testo.
            o alla pressione del tasto freccia su deve comparire nella casella 
              di testo l'ultimo comando passato.
            o alla pressione del tasto freccia giù deve comparire nella casella 
              di testo il comando passato successivamente.
         */
        inputField.setOnKeyPressed((KeyEvent event) -> {
            String tmp;
            /*se è stato premuto enter, si passa la stringa scritta nella casella
                di testo al parser*/
            if (event.getCode().equals(KeyCode.ENTER)) {
                buttonPush.fire();
            }
            /*se è stata premuta freccia su, si prende il comando passato precedentemente a
                quello in cui si sta iterando. Se non ci sono comandi precedenti, non fa nulla.*/
            if (event.getCode().equals(KeyCode.UP)) {
                try {
                    it = prevs.listIterator(index);

                    tmp = it.previous();
                    if (!tmp.isEmpty()) {
                        inputField.setText(tmp);
                    }
                    index--;
                } catch (IndexOutOfBoundsException | NoSuchElementException ex) {
                    index = 0;

                }
            }
            /*se è stata premuta freccia giù, si prende il comando passato successivamente a
                quello in cui si sta iterando. Se non ci sono comandi successivi, si inserisce la
                stringa vuota nella casella di testo.*/
            if (event.getCode().equals(KeyCode.DOWN)) {
                try {
                    it = prevs.listIterator(index);

                    tmp = it.next();
                    if (!tmp.isEmpty()) {
                        inputField.setText(tmp);
                    }
                    index++;
                } catch (IndexOutOfBoundsException | NoSuchElementException ex) {
                    inputField.setText("");
                    index = prevs.size();

                }

            }

        });
        //si inizializza lo stack delle variabili.
        variablesStack = VariablesStack.getInstance();
        observableList.addAll(solver.getStructureStack().getStack());
        listView.setItems(observableList);
        variablesList = FXCollections.observableArrayList();
        operationsList = FXCollections.observableArrayList();

    }

    @FXML
    private void ActionPush(ActionEvent event) throws InvalidVariableNameException, NonExistingVariable {
        try {//alla pressione del tasto push, si legge il contenuto della casella di testo
            String text = inputField.getText();
            //si aggiunge la stringa allo storico delle stringhe inserite se la stringa  non è vuota.
            if (!text.isEmpty()) {
                prevs.addLast(text);
                index = prevs.size();
            }
            OperationCommand code = null;

            try {//si passa la stringa passata al parser.
                code = decoratorParserOperation.parse(text);

            } catch (ArrayIndexOutOfBoundsException e) {
                alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
                inputField.clear();
                return;
            } catch (OperationNotFoundException ex) {
                alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
                return;

            } catch (NullPointerException ex) {
                alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
                return;

            } catch (ExistingNameException ex) {
                /*se è stato riscontrato un inserimento di una variabile che ha già valore 
                si chiede se la si vuole sovrascrivere*/
                //viene mostrato un Alert che chiede come si vuole procedere.
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Operazione già inserita");
                alert.setHeaderText("L'operazione è già stata inserita");
                alert.setContentText("Vuoi sovrascriverla?");
                Optional<ButtonType> result = alert.showAndWait();
                //se la risposta è sì, si sovrascrive.
                if (result.get() == ButtonType.OK) {
                    String textString = decoratorParserOperation.clearStringOperation(text);
                    String[] string = textString.split("\\$");
                    String possible_name = string[0];
                    possible_name = possible_name.replaceAll(" ", "");
                    decoratorParserOperation.removeOperation(possible_name);
                    decoratorParserOperation.parse(text);
                    inputField.clear();

                    return;
                } else {
                    //Altrimenti si pulisce la casella di testo.

                    inputField.clear();
                    return;
                }

            } catch (CollisionException ex) {
                /*se è stato riscontrata una collisione si chiede di chiarire l'
                ambiguità*/
                String message = ex.getMessage();
                ButtonType jNumber = new ButtonType("Inserimento Numero");
                ButtonType operation = new ButtonType("Operazione con Variabile");

                Alert alert = new Alert(AlertType.WARNING, "Sembra che ci sia un probelma" + "C'è stata una collisione, cosa intendi fare?", jNumber, operation);
                alert.showAndWait();
                if (alert.getResult() == operation) {
                    if (message.charAt(0) == '+') {
                        code = new SumVariableCommand();
                        ((SumVariableCommand) code).setVariable(message.charAt(1));
                        ((SumVariableCommand) code).setDictionary(VariablesDict.getInstance());
                    } else {
                        code = new DiffVariableCommand();
                        ((DiffVariableCommand) code).setVariable(message.charAt(1));

                        ((DiffVariableCommand) code).setDictionary(VariablesDict.getInstance());

                    }
                } else {
                    if (alert.getResult() == jNumber) {
                        code = new ComplexNumberParser(new ParserString()).parse(message);
                    }
                }
            } catch (Exception ex) {
                alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
            }
            if (code != null) {
                Stack structureStack = new Stack();
                structureStack.getStack().addAll(this.solver.getStructureStack().getStack());
                try {
                    solver.resolveOperation(code);
                } catch (EmptyStackException ex) {
                    alert("Errore!", "Operazione non valida", "Lo stack è vuoto!");
                    inputField.clear();
                    return;
                } catch (NotApplicableOperation ex) {
                    alert("Errore!", "Operazione non valida", "");
                    inputField.clear();
                    return;
                } catch (InvalidNumberException ex) {
                    alert("Errore!", "Inserito un numero non valido", text);
                    inputField.clear();
                    return;
                } catch (InvalidVariableNameException ex) {
                    alert("Errore!", "Inserito una variabile non valida", text);
                    inputField.clear();
                    return;
                } catch (UndefinedPhaseException ex) {
                    alert("Errore!", "Fase non definita", text);
                    this.solver.getStructureStack().clear();
                    this.solver.getStructureStack().push(structureStack.getStack());
                    inputField.clear();
                    return;
                } catch (DivisionByZeroException ex) {
                    alert("Errore!", "Divisione per zero.", "");
                    this.solver.getStructureStack().clear();
                    this.solver.getStructureStack().push(structureStack.getStack());
                    inputField.clear();
                    return;
                } catch (VariableExistingException ex) {
                    Alert alert = new Alert(AlertType.WARNING, "Variabile" + ((NewVariableCommand) code).getVariable() + " esistente, sovrascriverne il valore? ", ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES) {
                        OverrideVariableCommand ovc = new OverrideVariableCommand((NewVariableCommand) code);
                        solver.resolveOperation(ovc);
                    }

                }

            } else {
                alert("Attenzione!", "impossibile eseguire l'operazione richiesta.", "operazione sconosciuta.");
                inputField.clear();
                return;

            }

            observableList.clear();
            observableList.addAll(solver.getStructureStack().getStack());
            inputField.clear();

        } catch (InvalidNumberException ex) {
            alert("Errore!", "Operazione non valida", "L'inserimento non è valido");
        } catch (EmptyStackException ex) {
            alert("Errore!", "Operazione non valida", "Stack vuoto");
        } catch (UndefinedPhaseException ex) {
            alert("Errore!", "Operazione non valida", "fase non definita");
        } catch (DivisionByZeroException ex) {
            alert("Errore!", "Operazione non valida", "Divisione per zero");
        } catch (Exception ex) {
            alert("Errore!", "Operazione non valida", "Si è verificato un errore...");
        }

        this.setVariablesList();

    }

    public void setVariablesList() {
        String s = "";
        VariableSet variableSet;
        variablesList.clear();
        for (Character ch : variableParser.getDict().getTable().keySet()) {
            ComplexNumber value;
            try {
                value = variableParser.getDict().getVariableValue(ch);
                variableSet = new VariableSet(ch.toString(), value.toString());
                variablesList.add(variableSet);

            } catch (InvalidVariableNameException | NonExistingVariable ex) {

            }

        }

    }

    @FXML
    public void numberOnText(ActionEvent ae) {
        String no = ((Button) ae.getSource()).getText();
        inputField.setText(inputField.getText() + no);
    }

    @FXML
    public void operationOnText(ActionEvent ae) {
        String no = ((Button) ae.getSource()).getText();
        inputField.setText(inputField.getText() + no);
    }

    @FXML
    void divisionOnText(ActionEvent event) {
        inputField.setText(inputField.getText() + "/");
    }

    @FXML
    void multiplicationOnText(ActionEvent event) {
        inputField.setText(inputField.getText() + "*");
    }

    @FXML
    void sqrtOnText(ActionEvent event) {
        inputField.setText(inputField.getText() + "sqrt");
    }

    @FXML
    void invertedOnText(ActionEvent event) {
        inputField.setText(inputField.getText() + "+-");
    }

    public void alert(String title, String headerText, String contentText) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK);
        });

    }

    @FXML
    private void ActionClear(ActionEvent event) throws EmptyStackException {

        this.solver.getStructureStack().clear();
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());

    }

    @FXML
    private void ActionDrop(ActionEvent event) throws EmptyStackException {
        this.solver.getStructureStack().drop();
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());
    }

    @FXML
    private void ActionDuplicate(ActionEvent event) throws EmptyStackException {
        this.solver.getStructureStack().duplicate();
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());
    }

    @FXML
    private void ActionSwap(ActionEvent event) throws EmptyStackException, InvalidOperationException {
        this.solver.getStructureStack().swap();
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());
    }

    @FXML
    private void ActionOver(ActionEvent event) throws EmptyStackException, InvalidOperationException {
        this.solver.getStructureStack().over();
        observableList.clear();
        observableList.addAll(solver.getStructureStack().getStack());
    }

    /**
     * Il metodo salva le operazione definite dall'utente in un file scelto
     * dall'utente.
     *
     *
     */
    public void saveFunctions() {

        try {
            FileChooser fc = new FileChooser();
            fc.setTitle("Save functions ...");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
            File file = fc.showSaveDialog(new Stage());
            //se il file non è stato scelto
            if (file == null) {
                return;
            }
            //una volta scelto il file, si costruisce la stringa da stampare nel file
            PrintWriter pw = new PrintWriter(file);
            String s = "";
            //per tutte le operazioni definite dall'utente
            for (String name : operationDict.getNames()) {
                s += name + " -->";
                //viene salvata la lista contenente tutti i comandi dell'operazione associate al nome 
                LinkedList<OperationCommand> supportList = operationDict.getOperations(name).getCommandList();
                /*
                In questo caso a seconda del tipo di Comando, la stampa è diversa. 
                Nel caso in cui sia un ExecuteUserDefinedOperationCommand, viene salvato solamente il nome
                cosi da non perdere le relazioni che possono esserci tra varie operazioni.
                Nel caso in cui sia un'istanza di VariableCommand, ne viene usato il toString, in cui a seconda
                dell'operazione viene salvato nel file. Altrimento si usa il toString indifferentemente dal tipo 
                di OperationCommand.
                 */
                for (OperationCommand command : supportList) {
                    if (command instanceof ExecuteUserDefinedOperationCommand) {
                        s += " " + ((ExecuteUserDefinedOperationCommand) command).getName();
                    } else if (command instanceof VariableCommand) {
                        s += " " + ((VariableCommand) command).toString();
                    } else {
                        s += " " + command.toString();
                    }
                }
                s += "\n";
            }
            pw.print(s);
            pw.close();
        } catch (FileNotFoundException ex) {
            this.alert("Impossibile effettuare il salvataggio sul file", "Errore", " ");
        }
    }

    /**
     * Il metodo carica le operazione definite dall'utente da un file scelto
     * dall'utente.
     *
     *
     */
    public void uploadFunctions() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file ...");
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            Scanner sc;
            try {
                sc = new Scanner(file);
                //il file viene letto riga per riga, poiché in ognuna di esse c'è un operazione.

                while (sc.hasNext()) {
                    String line = sc.nextLine();
                    //la save salva le operazioni in questo modo:
                    // nameFunction : + + + 
                    try {
                        String name = line.split("-->")[0];
                        String operations = line.split("-->")[1];
                        //una volta salvate le operazioni associate al nome
                        //viene salvato il pattern che viene utilizzato per caricare le operazioni
                        //>>nameFunctions $ + + + 
                        String text = ">>" + name + "$" + operations;

                        try {
                            //si utilizza in questo caso il parser che salva appunto le operazioni.
                            decoratorParserOperation.parse(text);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
                            inputField.clear();
                            return;
                        } catch (OperationNotFoundException ex) {
                            alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
                        } catch (NullPointerException ex) {
                            alert("Errore!", "Operazione non valida", text + "--> L'inserimento non è valido");
                        } catch (ExistingNameException ex) {
                            //se si cerca di sovrascrivere un'operazione definita dall'utente
                            //si chiede se questa vuole essere sovrascritta o meno.
                            Alert alert = new Alert(AlertType.CONFIRMATION);
                            alert.setTitle("Operazione " + name + "è  già inserita");
                            alert.setHeaderText("L'operazione " + name + " è già stata inserita");
                            alert.setContentText("Vuoi sovrascriverla?");
                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK) {
                                String textString = decoratorParserOperation.clearStringOperation(text);
                                String[] string = textString.split("\\$");
                                String possible_name = string[0];
                                possible_name = possible_name.replaceAll(" ", "");
                                decoratorParserOperation.removeOperation(possible_name);
                                decoratorParserOperation.parse(text);

                            } else {
                                inputField.clear();
                                return;
                            }

                        } catch (Exception ex) {

                        } finally {
                            continue;
                        }

                    } catch (ArrayIndexOutOfBoundsException e) {
                        this.alert("Errore!", "Errore nella lettura del file ", "Pattern sbagliato");
                        return;
                    }

                }
            } catch (FileNotFoundException ex) {
                this.alert("Errore!", "Errore nell'apertura del file", "");
            }

        }

    }

    private void variablesHandlerAction(ActionEvent event) {
        if (event.getSource() == variablesHandler) {
            LoadStages("VariablesManager.fxml");
        }
    }

    private void LoadStages(String fxml) {
        try {
            Parent root;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            root = fxmlLoader.load();
            VariablesManagerController variableHandlerPaneController = fxmlLoader.getController();
            variableHandlerPaneController.setObservableList(variablesList);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("file:MathSolverIcon.jpg"));
            stage.setTitle("Variabili Definite");
            stage.show();

        } catch (IOException e) {
            System.err.println("Error while opening new window.");
        }
    }

    private void operationHandlerAction(ActionEvent event) {
        try {
            Parent root;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OperationsManager.fxml"));
            root = fxmlLoader.load();
            OperationsManagerController operationsManagerController = fxmlLoader.getController();
            //operationsManagerController.setObservableListOperations(operationsList);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("file:MathSolverIcon.jpg"));
            stage.setTitle("Operazioni  Definite");
            stage.show();

        } catch (IOException e) {
            System.err.println("Error while opening new window.");
        }

    }

    @FXML
    private void minusVarButtonActionPush(ActionEvent event) {
    }

    @FXML
    private void saveButtonActionPush(ActionEvent event) {
    }

    @FXML
    private void loadButtonActionPush(ActionEvent event) {
    }

    @FXML
    private void plusVarButtonActionPush(ActionEvent event) {
    }

}
