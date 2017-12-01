import java.util.ArrayList;

public class LineToken {

	ArrayList<String> tok;

	public LineToken(ArrayList<String> arrayList) {
		tok = arrayList;
	}

	public ArrayList<String> getTok() {
		return tok;
	}

	public void setTok(ArrayList<String> tok) {
		this.tok = tok;
	}
}
