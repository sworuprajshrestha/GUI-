/**
 * The given attributes are with their respective data type and the GymMember is a parent class and is an abstract class.
 * where as the each attributes has a own corresponding accessor method
 * where as, if GymMember also want to get membership form, so their is method activeMembership, where they can successfully 
 * active the membership.
 *
 * @author (Sworup Raj Shrestha)
 * @version (4/12/2025)
 */
public abstract class GymMember
{
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String dateOfBirth;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;

    public GymMember(int id, String name, String location, String phone, String email, String gender, String dateOfBirth, 
            String membershipStartDate)
    {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
        this.activeStatus = false;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getLocation()
    {
        return this.location;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getGender()
    {
        return this.gender;
    }

    public String getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public String getMembershipStartDate()
    {
        return this.membershipStartDate;
    }

    public double getLoyaltyPoints()
    {
        return this.loyaltyPoints;
    }

    public boolean getActiveStatus()
    {
        return this.activeStatus;
    }

    public int getAttendance()
    {
        return this.attendance;
    }

    public abstract void MarkAttendance();

    public void ActivateMembership()
    {
        if (!this.activeStatus) {
            this.activeStatus = true;
            System.out.println("The member " + this.id + " has been activated.");
        } else {
            System.out.println("The member " + this.id + " is already activated.");
        }
    }

    public void DeactivateMembership()
    {
        if (this.activeStatus) {
            this.activeStatus = false;
            System.out.println("The member " + this.id + " has been deactivated.");
        } else {
            System.out.println("The member " + this.id + " is already deactivated.");
        }
    }

    public void ResetMember()
    {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0;
        System.out.println("The membership " + this.id + " is successfully reset.");
    }

    public void display()
    {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Location: " + this.location);
        System.out.println("Phone: " + this.phone);
        System.out.println("Email: " + this.email);
        System.out.println("Gender: " + this.gender);
        System.out.println("Date of Birth: " + this.dateOfBirth);
        System.out.println("Membership Start Date: " + this.membershipStartDate);
        System.out.println("Attendance: " + this.attendance);
        System.out.println("Loyalty Points: " + this.loyaltyPoints);
        System.out.println("Active Status: " + this.activeStatus);
    }
}