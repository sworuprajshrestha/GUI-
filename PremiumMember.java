/**
 * The premium class is a subclass of GymMember class that is child class of GymMember class
 * where as it has three attributes it also accept Nine parameter such as Id name Location Phone and so on where as it means the call is made to the super class 
 * constructor with eight parameters.where in this class its shows the total amount paid and the discount that they have received.
 *
 * @author (Sworup Raj Shrestha)
 * @version (4/12/2025)
 */
public class PremiumMember extends GymMember
{
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    public PremiumMember(int id1, String name1, String location1, String phone1, String email1, String gender1,
            String dateOfBirth1, String membershipStartDate1, String personalTrainer1)
    {
        super(id1, name1, location1, phone1, email1, gender1, dateOfBirth1, membershipStartDate1);
        this.premiumCharge = 50000;
        this.paidAmount = 0;
        this.isFullPayment = false;
        this.discountAmount = 10;
        this.personalTrainer = personalTrainer1;
    }

    public double getPremiumCharge()
    {
        return this.premiumCharge;
    }

    public String getPersonalTrainer()
    {
        return this.personalTrainer;
    }

    public boolean isFullPayment()
    {
        return this.isFullPayment;
    }

    public double getPaidAmount()
    {
        return this.paidAmount;
    }

    public double getDiscountAmount()
   {
        return this.discountAmount;
   }

   @Override
    public void MarkAttendance()
    {
        if (activeStatus) {
            attendance++;
            loyaltyPoints += 10;
        }
    }

    public String PayDueAmount(double amount) {
    if (isFullPayment) {
        return "Payment is already completed.";
    }
    
    if (amount <= 0) {
        return "Payment amount must be positive.";
    }
    double remainingAmount = premiumCharge - paidAmount;
    if (amount > remainingAmount) {
        return "Overpayment detected. Maximum payable amount is " + remainingAmount;
    }
    paidAmount += amount;
    if (paidAmount >= premiumCharge) {
        paidAmount = premiumCharge; // Prevent overpayment
        isFullPayment = true;
        CalculateDiscount(); // Automatically calculate discount upon full payment
        return "Payment of " + amount + " processed successfully. Membership fully paid! Discount applied.";
    } else {
        return "Payment of " + amount + " processed successfully. Remaining: " + (premiumCharge - paidAmount);
    }
    }

    public void CalculateDiscount()
    {
        if (isFullPayment) {
            this.discountAmount = 0.1 * premiumCharge;
            System.out.println("Your discount amount is " + discountAmount);
        } else {
            this.discountAmount = 0;
            System.out.println("Not eligible for discount");
        }
    }

    public String RevertPremiumMember()
    {
        super.ResetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
        return "Premium member has been reverted.";
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Personal Trainer: " + this.personalTrainer);
        System.out.println("Paid Amount: " + this.paidAmount);
        System.out.println("Remaining Amount: " + (premiumCharge - this.paidAmount));
        System.out.println("Full Payment Status: " + this.isFullPayment);
        if (isFullPayment) {
            System.out.println("Discount Amount: " + this.discountAmount);
        }
    }
}