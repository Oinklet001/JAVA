/**
 * Alisson Leiva Salazar
 */
package abstraction;

import javax.swing.JOptionPane;

public class SavingsAccount extends BankAccount {
	
	private double numDep;
	private double numWit;
	private boolean boolActive;
	
	//Getter
	public boolean getBool(){
		return this.boolActive;
		
	}
	
	//Constructor
	
	public SavingsAccount(){
		numDep=0;
		numWit=0;
		boolActive=false;
	}
	
	public SavingsAccount(double d, double w, boolean f,
			double b, double a){
		
		super(b,a);
		
		this.numDep=d;
		this.numWit=w;
		this.boolActive=f;
		
	}
	@Override
	public void deposit(double dep){
		
		setBalance(getBalance()+dep);
		//FALSE to becoming Inactive
		if (super.getBalance() < 25){
			this.boolActive=false;
			JOptionPane.showMessageDialog(null, "Inactive");
		}
		else{
			this.boolActive=true;
			JOptionPane.showMessageDialog(null, "Active");
		}
	
		
				
	}
	@Override
	public void withdraw(double wit){
		
		setBalance(getBalance()-wit);
		//IF the boolean is false
		//Do not allow withdraw
		if(this.boolActive == false){
			JOptionPane.showMessageDialog(null, "Can't Withdraw.");
			
		}
		else{
			JOptionPane.showMessageDialog(null, "Can Withdraw.");
		}
		//If balance after withdraw < 25
		//return boolean false
		if(super.getBalance() < 25){
			this.boolActive=false;
			
		}
			
	}
	
	@Override
	public double monthlyProcess(){
		
		if(numDep > 4 || numWit > 4){
			monthServ+=Math.max(0.0,(numDep-4)*1);
			monthServ+=Math.max(0.0,(numWit-4)*1);
		}
		
		return monthServ;
			
	}
	
	
}
