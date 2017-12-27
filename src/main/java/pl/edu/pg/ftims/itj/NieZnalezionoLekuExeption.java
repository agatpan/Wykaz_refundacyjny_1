package pl.edu.pg.ftims.itj;

public class NieZnalezionoLekuExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -234101041792141387L;
	public String message;

	public NieZnalezionoLekuExeption(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
