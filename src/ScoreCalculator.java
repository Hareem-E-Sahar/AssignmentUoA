
public class ScoreCalculator {
	
	public static double calculateScore( double a )
	{
	return (Math.log(a) / Math.log(2));
	}
	public static double calculateScore( double a, double b )
	{
	return (Math.log(a) / Math.log(2))*(Math.log(b)/Math.log(2));
	}
}
