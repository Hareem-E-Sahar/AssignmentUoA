import java.util.ArrayList;

public class LineTokenInt {
 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tok == null) ? 0 : tok.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineTokenInt other = (LineTokenInt) obj;
		if (tok == null) {
			if (other.tok != null)
				return false;
		} else if (!tok.equals(other.tok))
			return false;
		return true;
	}

ArrayList <Integer> tok;
 
 public LineTokenInt(ArrayList<Integer> arrayList) {
		tok = arrayList;
	}


public ArrayList<Integer> getTok() {
	return tok;
}

public void setTok(ArrayList<Integer> tok) {
	this.tok = tok;
}


}
