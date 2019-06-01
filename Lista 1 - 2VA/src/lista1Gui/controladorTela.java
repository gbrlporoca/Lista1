package lista1Gui;

import lista1Dados.*;
import lista1Exceções.*;
import lista1Negcios.*;
import lista1Beans.*;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class controladorTela implements EventHandler<Event> {
	
	@FXML
    private Button BRemover;

    @FXML
    private Button BAtualizar;
	
	@FXML
    private Button BCadastrar;

    @FXML
    private ChoiceBox<TipoMedalha> escolhaTipo;

    @FXML
    private ChoiceBox<Modalidade> escolhaModalidade;

    @FXML
    private ChoiceBox<Pais> escolhaPais;

    @FXML
    private TableView<Medalha> tabela;

    @FXML
    private TableColumn<Medalha, TipoMedalha> tabelaTipo;

    @FXML
    private TableColumn<Medalha, Modalidade> tabelaModalidade;

    @FXML
    private TableColumn<Medalha, Pais> tabelaPais;
    
    @FXML
    private Button BOrdenarModalidade;
    
    @FXML
    private ChoiceBox<Pais> escolhaPaisTipo;
    
    @FXML
    private Button BConsultar;
    
    @FXML
    private Label consulta;
    
    ControladorMedalhas medalhas = ControladorMedalhas.getInstance();

    ObservableList<Medalha> m = FXCollections.observableArrayList();
    
    ArrayList<Integer> auxiliar = new ArrayList<Integer>();

    public ObservableList<Medalha> getMedalha() {

        m.addAll(RepMedalhas.getInstance().listar());

        return m;

    }

    public void initialize() {
    	
    	tabela.getSelectionModel();

        List<Modalidade> mod =  Arrays.asList(Modalidade.values());
        List<TipoMedalha> tipo =  Arrays.asList(TipoMedalha.values());
        List<Pais> pais =  Arrays.asList(Pais.values());
        
        ObservableList<Modalidade> modalidade = FXCollections.observableArrayList(mod);
        ObservableList<TipoMedalha> tipomedalha = FXCollections.observableArrayList(tipo);
        ObservableList<Pais> p = FXCollections.observableArrayList(pais);
        
        tabelaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tabelaModalidade.setCellValueFactory(new PropertyValueFactory<>("modalidade"));
        tabelaPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        
        tabela.setItems(FXCollections.observableList(medalhas.listar()));
        
        escolhaModalidade.setItems(modalidade);
        escolhaTipo.setItems(tipomedalha);
        escolhaPais.setItems(p);
        escolhaPaisTipo.setItems(p);
        
    }
    
    private void showAlertWithHeaderText(Exception e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(e.getMessage());
        alert.show() ;
    }
        
    @Override
    public void handle(Event evento) {

    	
    	if(evento.getSource().equals(BCadastrar)) {
    		Medalha m = new Medalha(escolhaTipo.getValue(), escolhaModalidade.getValue(), escolhaPais.getValue());
    			try {
    				medalhas.cadastrar(m);
    				tabela.refresh();
    			}catch(MJEException mje) {
    				showAlertWithHeaderText(mje);
    			}catch(CNPException cnp) {
    				showAlertWithHeaderText(cnp);
    			}
    		}else if(evento.getSource().equals(BRemover)){
    			
    			try {
    				medalhas.remover(tabela.getSelectionModel().getSelectedItem());
    				tabela.refresh();
    			}catch(MNEException mne) {
    				showAlertWithHeaderText(mne);
    			}
    			
    		}else if(evento.getSource().equals(BOrdenarModalidade)) {
    			medalhas.ordenarModalidade();
    			tabela.refresh();
    		}else if(evento.getSource().equals(BAtualizar)) {
    			try {
    				Medalha medalhaNova = new Medalha(escolhaTipo.getValue(), escolhaModalidade.getValue(), escolhaPais.getValue());
    				Medalha medalhaAntiga = tabela.getSelectionModel().getSelectedItem();
    				medalhas.atualizar(medalhaAntiga, medalhaNova);
    				tabela.refresh();
    			}catch(MNEException mne) {
    				showAlertWithHeaderText(mne);
    			}catch(MJEAException2 mjae) {
    				showAlertWithHeaderText(mjae);
    			}
    			
    		}else if(evento.getSource().equals(BConsultar)) {
    			int ouro = medalhas.totalTipoPais(escolhaPaisTipo.getValue(), TipoMedalha.OURO);
    			int prata = medalhas.totalTipoPais(escolhaPaisTipo.getValue(), TipoMedalha.PRATA);
    			int bronze = medalhas.totalTipoPais(escolhaPaisTipo.getValue(), TipoMedalha.BRONZE);
    			consulta.setText("Ouro : " + ouro + "\nPrata : " + prata + "\nBronze : " + bronze);
			}
    	
    }
}