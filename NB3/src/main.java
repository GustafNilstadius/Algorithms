
public class main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		StringBuilder string = new StringBuilder();
		string.append("R = [");
		for (int i = 0; i < 30; i++) {
			String tmp = new String("" + function(i));
			string.append(tmp);
			System.out.println("n = " + i + " r = " + tmp);
			string.append(" ");
		}
		string.append("]");
		System.out.println(string.toString());
		
		/*
		int r=0, n=10;
		for(int i=1;i<=	n;i++)
			for(int	j=1;j<=	i;j	++)
				for(int	k=j;k<=i+j;k++)
					for(int	m=1;m<=i+j-k;m++)
						r++;
		 */

	}
	
	public static int function (int n){
		int r=0;
		for(int i=1;i<=	n;i++)
			for(int	j=1;j<=	i;j	++)
				for(int	k=j;k<=i+j;k++)
					for(int	m=1;m<=i+j-k;m++)
						r++;
		return r;
	}

}
