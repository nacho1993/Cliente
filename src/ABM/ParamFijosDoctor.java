package ABM;

import java.util.ArrayList;

public class ParamFijosDoctor extends ParamFijos {

	private static String dirtabla="Doctor";
	private static String[][] campos= 
								{{"DNI", "Documento", "K"},            
								{"Nombre", "Nombre", null},             
								{"Apellido", "Apellido", null},        
								{"Estado", "Estado", null}};      
	private static ArrayList<String[]> claves=null;
	private static String[][] tipocampos=null;
	private static ArrayList<String[]> valoreschosen=null;
	
	//DIRTABLA	
		@Override
		public String getDT() {
			return dirtabla;
		}

		@Override
		public void setDT(String dirtabla) {
			ParamFijosDoctor.dirtabla = dirtabla;
		}

	//CAMPOS	
		@Override
		public String[][] getCM() {
			return campos;
		}
		
		@Override
		public void setCM(String[][] campos) {
			ParamFijosDoctor.campos = campos;
		}
		
	//CLAVES
		@Override
		public ArrayList<String[]> getCL() {
			return claves;
		}

		@Override
		public void setCL(ArrayList<String[]> claves) {
			ParamFijosDoctor.claves = claves;
		}
		
	//TIPOCAMPOS
		@Override
		public String[][] getTC() {
			
			return tipocampos;
		}

		@Override
		public void setTC(String[][] tipocampos) {
			ParamFijosDoctor.tipocampos = tipocampos;
		}
		
	//VALORES CHOSEN
		@Override
		public ArrayList<String[]> getVC() {
			return valoreschosen;
		}

		@Override
		public void setVC(ArrayList<String[]> valoreschosen) {
			ParamFijosDoctor.valoreschosen = valoreschosen;
		}

}
