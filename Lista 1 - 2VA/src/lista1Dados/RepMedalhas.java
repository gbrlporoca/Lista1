package lista1Dados;
import java.util.ArrayList;
import lista1Beans.*;
import lista1Exceções.*;
import java.util.Collections;


public class RepMedalhas {
	
	private ArrayList<Medalha> medalhas;
	private static RepMedalhas instance;
	
	private RepMedalhas() {
		this.medalhas = new ArrayList<Medalha>();
	}
	
	public static RepMedalhas getInstance() {
		if (instance == null) {
			RepMedalhas.instance = new RepMedalhas(); 
		}
		return instance;
	}
	
	public void cadastrar(Medalha m) throws MJEException, CNPException{
		if(!this.medalhas.contains(m) || m.getTipo() == null ||m.getModalidade() == null || m.getPais() == null) {
			medalhas.add(m);
		}else if (this.medalhas.contains(m)){
			MJEException mje = new MJEException();
			throw mje;
		}else {
			CNPException cnp = new CNPException();
			throw cnp;
		}
	}
	
	public ArrayList<Medalha> listar() {
		return medalhas;
	}
	
	public void atualizar(Medalha antiga, Medalha nova) throws MNEException, MJEAException2{
		if(medalhas.contains(antiga) && !medalhas.contains(nova)) {
			int x = medalhas.indexOf(antiga);
			medalhas.set(x, nova);
		}else if(medalhas.contains(antiga) == false) {
			MNEException mne = new MNEException();
			throw mne;
		}else {
			MJEAException2 mjae = new MJEAException2();
			throw mjae;
		}
	}
	
	public void remover(Medalha m) throws MNEException{
		if(medalhas.contains(m)) {
			medalhas.remove(m);
		}else {
			MNEException mne = new MNEException();
			throw mne;
		}
	}
	
	public void ordenarModalidade() {
		Collections.sort(medalhas);
	}
	
	public int totalMedalhasPais(Pais pais, TipoMedalha tipo){
			int resultado = 0;
			for(Medalha medalha: medalhas) {
				if(medalha.getPais() ==  pais && medalha.getTipo() == tipo) {
					resultado++;
				}
			}
			return resultado;
			
		}
}
