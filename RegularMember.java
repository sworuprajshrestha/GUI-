/**
 * This class is a Subclass that means a child class of GymMember class
 * where as, it has six private attributes such as, price, AttendanceLimit, isEligibleForUpgrade
 * and so on. while in this class the call is made to the superclass constructor with eight parameters.
 * while in this class its shows the plans and the price of the GymMember class.
 *
 * @author (Sworup Raj Shrestha)
 * @version (4/12/2025)
 */
public class RegularMember extends GymMember
{
    private final int AttendanceLimit;
    private boolean isEligibleForUpgrade;
    private String Removalreason;
    private String Referralsource;
    private String plan;
    private double price;

    public RegularMember(int id1, String Name1, String Location1, String Phone1, 
            String Email1, String Gender1, String DateOfBirth1, String MembershipStartDate1, String Referralsource1)
    {
        super(id1, Name1, Location1, Phone1, Email1, Gender1, DateOfBirth1, MembershipStartDate1);
        this.isEligibleForUpgrade = false;
        this.AttendanceLimit = 30;
        this.plan = "Basic";
        this.price = 6500;
        this.Removalreason = "";
        this.Referralsource = Referralsource1;
    }

    public int getAttendanceLimit()
    {
        return this.AttendanceLimit;
    }

    public boolean isEligibleForUpgrade()
    {
        return this.isEligibleForUpgrade;
    }

    public String getRemovalReason()
    {
        return this.Removalreason;
    }

    public String getReferralSource()
    {
        return this.Referralsource;
    }

    public String getPlan()
    {
        return this.plan;
    }

    public double getPrice()
    {
        return this.price;
    }

    @Override
    public void MarkAttendance()
    {
        if (activeStatus) {
            attendance++;
            loyaltyPoints += 5;
            if (attendance >= AttendanceLimit) {
                isEligibleForUpgrade = true;
            }
        }
    }

    public double getPlanPrice(String plan)
    {
        switch (plan) {
            case "Basic":
                return 6500;
            case "Standard":
                return 12500;
            case "Deluxe":
                return 18500;
            default:
                return -1;
        }
    }

    public String Upgradeplan(String newPlan)
    {
        if (!newPlan.equals("Basic") && !newPlan.equals("Standard") && !newPlan.equals("Deluxe")) {
            return "Invalid plan: " + newPlan;
        }

        if (newPlan.equals(plan)) {
            return "You are already subscribed to the " + newPlan + " plan";
        }

        if (attendance >= AttendanceLimit) {
            isEligibleForUpgrade = true;
        } else {
            isEligibleForUpgrade = false;
        }

        if (isEligibleForUpgrade) {
            double newPrice = getPlanPrice(newPlan);
            plan = newPlan;
            price = newPrice;
            return "Your plan has been upgraded to " + newPlan + " successfully";
        } else {
            return "You are not eligible for a plan upgrade";
        }
    }

    public String RevertRegularMember(String removalReason)
    {
        super.ResetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.Removalreason = removalReason;
        return "Regular member has been reverted with reason: " + removalReason;
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Plan: " + this.plan);
        System.out.println("Price: " + this.price);
        System.out.println("Referral Source: " + this.Referralsource);
        if (!Removalreason.isEmpty()) {
            System.out.println("Removal Reason: " + this.Removalreason);
        }
    }
}