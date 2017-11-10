package ABM;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


public class ParamFijos {

	

	//variables y metodos para hacer override, nunca se llaman estos
	private String dirtabla;
	private String[][] campos;
	private ArrayList<String[]> claves;
	private String[][] tipocampos;
	private ArrayList<String[]> valoreschosen;
	
	public String getDT() {return dirtabla;}
	public String[][] getCM() {return campos;}
	public ArrayList<String[]> getCL() {return claves;}
	public String[][] getTC() {return tipocampos;}
	public void setDT(String dirtabla) {dirtabla = dirtabla;}
	public void setCM(String[][] campos) {campos = campos;}
	public void setCL(ArrayList<String[]> claves) {claves = claves;}
	public void setTC(String[][] tipocampos) {tipocampos = tipocampos;}
	public ArrayList<String[]> getVC() {return null;}
	public void setVC(ArrayList<String[]> valoreschosen) {}

	public static ParamFijos getABM(String jsp){
		ParamFijos pf=null;
		switch(jsp){

		case "ABMDoctor.jsp":
			return pf = new ParamFijosDoctor();			
		}
		return pf;
	}
//dirtabla	
	public static String getDirtabla(String jsp){
		ParamFijos pf = getABM(jsp);
		return pf.getDT();
	}
	public static void setDirtabla(String jsp, String dirtabla){

		ParamFijos pf = getABM(jsp);
		pf.setDT(dirtabla);
	}
	
//campos	
	public static String[][] getCampos(String jsp) {
		ParamFijos pf = getABM(jsp);
		return pf.getCM();
	}
	public static void setCampos(String jsp,String[][] campos) {
		ParamFijos pf = getABM(jsp);
		pf.setCM(campos);
	}

//claves
	public static ArrayList<String[]> getClaves(String jsp) {
		ParamFijos pf = getABM(jsp);
		if(pf.getCL()==null){	//si no existen las crea
			ArrayList<String[]> newclaves = new ArrayList<String[]>();
			String[][] campostemp = pf.getCM();
			//guarda claves controlando si el [i][2] no es null y en el arreglo "claves" copia todo del campo
			// y ademas agrega la posicion "i" del arreglo por si vienen desordenados
			for (int i = 0; i < campostemp.length; i++) {
				if(campostemp[i][2]!= null)
				{	String[] clave={campostemp[i][0],campostemp[i][1],campostemp[i][2],Integer.toString(i)};
					newclaves.add(clave);}}

			pf.setCL(newclaves);
			
		}
		return pf.getCL();
	}
	public static void setClaves(String jsp,ArrayList<String[]> claves) {
		ParamFijos pf = getABM(jsp);
		pf.setCL(claves);
		}

//tipo campos	
	public static String[][] getTipocampos(String jsp, HttpServletRequest request) {
		ParamFijos pf = getABM(jsp);
		
		if(pf.getTC()==null){	
			String tabla = pf.getDT();
			

			String[][] campostemp = pf.getCM();
			String[][] newtipocampos= new String[campostemp.length][2];

			//Se recupera de QSYS2.SYSCOLUMNS tipo de dato y longitud para cada campo y se guarda
			//en el arreglo tipocampos [i][0]=tipo dato [i][1]=longitud. La "i" se corresponde con el arreglo campos
			switch(tabla){

			case "Doctor":
				newtipocampos[1][0] = "int" ;
				newtipocampos[1][1] = "10";
				newtipocampos[2][0] = "text";
				newtipocampos[2][1] = "35";
				newtipocampos[2][0] = "text";
				newtipocampos[2][1] = "35";
				newtipocampos[2][0] = "boolean";
				newtipocampos[2][1] = "2";
						
			}
				
				
				
			
		pf.setTC(newtipocampos);
			
		}
		
		return pf.getTC();
		
		}
	
	public static void setTipocampos(String jsp,String[][] tipocampos) {
		ParamFijos pf = getABM(jsp);
		pf.setTC(tipocampos);
	}
//valores chosen
	public static ArrayList<String[]> getValoresChosen(String jsp){
		ParamFijos pf = getABM(jsp);
		return pf.getVC();
	}
	
	public static void setValoresChosen(String jsp, ArrayList<String[]> valoreschosen){

		ParamFijos pf = getABM(jsp);
		pf.setVC(valoreschosen);
	}

	
}
