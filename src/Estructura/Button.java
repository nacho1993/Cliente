package Estructura;

public class Button {
  public static final String CLASE_WARNING="warning";
  public static final String CLASE_INFO="info";
  public static final String CLASE_SUCCESS="success";
  public static final String CLASE_DANGER="danger";
  public static final String CLASE_PRIMARY="primary";
  public static final String CLASE_DEFAULT="default";
  
  public static final String TIPO_BUTTON="button";
  public static final String TIPO_SUBMIT="submit";
  public static final String TIPO_RESET="reset";
	/**
	 * 
	 * @param tipo puede ser: 
				 	button
				 	submit
				 	reset
	 * @param clase define el tipo de boton y puede tomar los siguientes valores:
				 	warning (amarillo)
				 	info    (celeste)
				 	success (verde)
				 	danger  (rojo)
	 * @param msj es el contenido del boton
	 * @param col es el tamano de las columnas en bootstrap
	 * @param offset es el tamano de la columna libre que se deja hacia la izquierda en bootstrap
	 * @return
	 */
	


	public static String impButton(String tipo,String clase,String msj, int col, int offset)
		{
			
			String button="<button type="+tipo+" class=\"btn btn-"+clase+" col-md-"+col+" col-md-offset-"+offset+" text-center\">"+msj+"</button>";
			return button;
		}
	public static String impButton(String tipo,String clase,String msj,String name, int col, int offset)
	{
		
		String button="<button type="+tipo+" class=\"btn btn-"+clase+" col-md-"+col+" col-md-offset-"+offset+" text-center\" name=\""+name+"\">"+msj+"</button>";
		return button;
	}
	public static String impButton(String tipo,String clase,String msj,String name, String extra, int col, int offset)
	{
		String button;
		if(name==null)
		{
			button="<button type="+tipo+" class=\"btn btn-"+clase+" col-md-"+col+" col-md-offset-"+offset+" text-center\" "+extra+">"+msj+"</button>";
		} else{
			button="<button type="+tipo+" class=\"btn btn-"+clase+" col-md-"+col+" col-md-offset-"+offset+" text-center\" name=\""+name+"\" "+extra+">"+msj+"</button>";
			
		}
		return button;
	}	
		
	
}
