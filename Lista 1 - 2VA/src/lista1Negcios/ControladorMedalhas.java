package lista1Negcios;
import java.util.ArrayList;
import lista1Beans.*;
import lista1Dados.*;
import lista1Exceções.*;


public class ControladorMedalhas{
	
	private RepMedalhas medalhas;
	private static ControladorMedalhas instance;
	
	private ControladorMedalhas(){
		medalhas = RepMedalhas.getInstance();
	}
	
	public static ControladorMedalhas getInstance() {
		if(instance == null) {
			ControladorMedalhas.instance = new ControladorMedalhas();
		}
		return instance;
	}
	
	public void cadastrar(Medalha m) throws MJEException, CNPException{
		try {
			medalhas.cadastrar(m);
		}catch(MJEException mje){
			throw mje;
		}catch(CNPException cnp) {
			throw cnp;
		}
	}
	
	public void remover(Medalha m) throws MNEException{
		try {
			medalhas.remover(m);
		}catch (MNEException mne){
			throw mne;
		}
	}
	
	public void atualizar(Medalha antiga, Medalha nova) throws MNEException, MJEAException2{
		try {
			medalhas.atualizar(antiga, nova);
		}catch (MNEException mne){
			throw mne;
		}catch (MJEAException2 mjae){
			throw mjae;
		}
	}
	
	public ArrayList<Medalha> listar(){
		return medalhas.listar();
	}
	
	public void ordenarModalidade(){
		medalhas.ordenarModalidade();
	}
	
	public int totalTipoPais(Pais pais, TipoMedalha tipo) {
		return medalhas.totalMedalhasPais(pais, tipo);
	}
	
}