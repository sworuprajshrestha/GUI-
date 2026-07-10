/**
 * This class is GymGUI and manages Regular and Premium gym memberships using a GUI.
 *
 * @author (Sworup Raj Shrestha)
 * @version (4/12/2025)
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GymGUI implements ActionListener
{
    ArrayList<GymMember> obj = new ArrayList<GymMember>();
    private JFrame frame1;
    private JPanel panel1;
    private Font font1;
    private Font font2;
    private Font font3;
    private Color color1;
    private JLabel label1;
    private JLabel detail1;
    private JLabel homedetail1;
    private JLabel service1;
    
    private JLabel Premiumid;
    private JLabel Regularid;
    private JLabel regularid1;
    private JLabel premiumid1;
    
    private JLabel regularname1;
    private JLabel regularlocation1;
    private JLabel regularphone1;
    private JLabel regularemail1;
    private JLabel regulargender1;
    private JLabel regulardob1;
    private JLabel regularsource1;
    private JLabel regularstartdate1;
    
    private JLabel premiumname;
    private JLabel premiumlocation;
    private JLabel premiumphone;
    private JLabel premiumemail;
    private JLabel premiumgender;
    private JLabel premiumdob;
    private JLabel premiumStartDate2;
    private JLabel premiumtrainer;

    private JTextField regularidtextfield;
    private JTextField regulartextname;
    private JTextField regulartextlocation;
    private JTextField regulartextphone;
    private JTextField regulartextemail;
    private JTextField regulartextsource;
    
    private JTextField premiumidtextfield;
    private JTextField premiumtextname;
    private JTextField premiumtextlocation;
    private JTextField premiumtextphone;
    private JTextField premiumtextemail;
    private JTextField premiumtexttrainer;
    private JTextField plan2;
    
    private JRadioButton premiummale;
    private JRadioButton premiumfemale;
    private JRadioButton regularmale;
    private JRadioButton regularfemale;
    private ButtonGroup regularbg;
    private ButtonGroup premiumbg;
    private JComboBox premiumdobdate;
    private JComboBox premiumdobmonth;
    private JComboBox premiumdobyear;
    private JComboBox premiumdate;
    private JComboBox premiummonth;
    private JComboBox premiumyear;
    private JComboBox regulardobdate;
    private JComboBox regulardobmonth;
    private JComboBox regulardobyear;
    private JComboBox regulardate;
    private JComboBox regularmonth;
    private JComboBox regularyear;
    private JComboBox Plan1;
    
    
    private JButton addpremium;
    private JButton revertpremium;
    private JButton removepremium;
    private JButton activepremium;
    private JButton deactivepremium;
    private JButton clearpremium;
    private JButton attendacepremium;
    private JButton uppremium;
    private JButton displayregular;
    private JButton readregular;
    private JButton saveregular;
    private JButton changetopremium;
    
    private JButton addregular;
    private JButton revertregular;
    private JButton removeregular;
    private JButton activeregular;
    private JButton deactiveregular;
    private JButton clearregular;
    private JButton upregular;
    private JButton displaypremium;
    private JButton calculated;
    private JButton readpremium;
    private JButton attendaceregular;
    private JButton savepremium;
    private JButton payremain;
    private JButton changetoregular;
    
    private JButton RegularMember;
    private JButton PremiumMember;
    private JTextField remReasonField;
    
    public void actionPerformed(ActionEvent e)
    {
        Object oh = e.getSource();
        
        // Clear Regular form
        if (oh == clearregular) {
            regularidtextfield.setText("");
            regulartextname.setText("");
            regulartextlocation.setText("");
            regulartextphone.setText("");
            regulartextemail.setText("");
            regulartextsource.setText("");    
            regularbg.clearSelection();    
            regulardobdate.setSelectedIndex(-1);
            regulardobmonth.setSelectedIndex(-1);
            regulardobyear.setSelectedIndex(-1);   
            regulardate.setSelectedIndex(-1);
            regularmonth.setSelectedIndex(-1);
            regularyear.setSelectedIndex(-1);
            remReasonField.setText("");
        }
        
        // Clear Premium form
        if (oh == clearpremium) {
            premiumidtextfield.setText("");
            premiumtextname.setText("");
            premiumtextlocation.setText("");
            premiumtextphone.setText("");
            premiumtextemail.setText("");
            premiumtexttrainer.setText("");      
            premiumbg.clearSelection();   
            premiumdobdate.setSelectedIndex(-1);
            premiumdobmonth.setSelectedIndex(-1);
            premiumdobyear.setSelectedIndex(-1);   
            premiumdate.setSelectedIndex(-1);
            premiummonth.setSelectedIndex(-1);
            premiumyear.setSelectedIndex(-1);
        }
        
        // Switch to Premium panel
        if (oh == PremiumMember || oh == changetopremium) {
            frame1.dispose();
            a2();
        }
        
        // Switch to Regular panel
        if (oh == RegularMember || oh == changetoregular) {
            frame1.dispose();
            a1();
        }
        
        // Add Regular Member
        if (oh == addregular) {
            try {
                int id = Integer.parseInt(regularidtextfield.getText().trim());
                String name = regulartextname.getText().trim();
                String location = regulartextlocation.getText().trim();
                String phone = regulartextphone.getText().trim();
                String email = regulartextemail.getText().trim();
                String gender = regularmale.isSelected() ? "Male" : regularfemale.isSelected() ? "Female" : "";
                String dob = (regulardobdate.getSelectedItem() != null ? regulardobdate.getSelectedItem() : "") + " " +
                             (regulardobmonth.getSelectedItem() != null ? regulardobmonth.getSelectedItem() : "") + " " +
                             (regulardobyear.getSelectedItem() != null ? regulardobyear.getSelectedItem() : "");
                String startDate = (regulardate.getSelectedItem() != null ? regulardate.getSelectedItem() : "") + " " +
                                   (regularmonth.getSelectedItem() != null ? regularmonth.getSelectedItem() : "") + " " +
                                   (regularyear.getSelectedItem() != null ? regularyear.getSelectedItem() : "");
                String referral = regulartextsource.getText().trim();
                
                boolean duplicate = false;
                for (GymMember m : obj) {
                    if (m.getId() == id) {
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) {
                    JOptionPane.showMessageDialog(frame1, "This ID already exists.");
                } else if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() || dob.contains("null") || startDate.contains("null") || referral.isEmpty()) {
                    JOptionPane.showMessageDialog(frame1, "Please fill all fields.");
                } else {
                    RegularMember rm = new RegularMember(id, name, location, phone, email, gender, dob, startDate, referral);
                    obj.add(rm);
                    JOptionPane.showMessageDialog(frame1, "Regular member added successfully.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "ID must be a number.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error adding Regular member: " + ex.getMessage());
            }
        }

        // Add Premium Member
        if (oh == addpremium) {
            try {
                int id = Integer.parseInt(premiumidtextfield.getText().trim());
                String name = premiumtextname.getText().trim();
                String location = premiumtextlocation.getText().trim();
                String phone = premiumtextphone.getText().trim();
                String email = premiumtextemail.getText().trim();
                String gender = premiummale.isSelected() ? "Male" : premiumfemale.isSelected() ? "Female" : "";
                String dob = (premiumdobdate.getSelectedItem() != null ? premiumdobdate.getSelectedItem() : "") + " " +
                             (premiumdobmonth.getSelectedItem() != null ? premiumdobmonth.getSelectedItem() : "") + " " +
                             (premiumdobyear.getSelectedItem() != null ? premiumdobyear.getSelectedItem() : "");
                String startDate = (premiumdate.getSelectedItem() != null ? premiumdate.getSelectedItem() : "") + " " +
                                   (premiummonth.getSelectedItem() != null ? premiummonth.getSelectedItem() : "") + " " +
                                   (premiumyear.getSelectedItem() != null ? premiumyear.getSelectedItem() : "");
                String trainer = premiumtexttrainer.getText().trim();
                
                boolean duplicate = false;
                for (GymMember m : obj) {
                    if (m.getId() == id) {
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) {
                    JOptionPane.showMessageDialog(frame1, "This ID already exists.");
                } else if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() || dob.contains("null") || startDate.contains("null") || trainer.isEmpty()) {
                    JOptionPane.showMessageDialog(frame1, "Please fill all fields.");
                } else {
                    PremiumMember pm = new PremiumMember(id, name, location, phone, email, gender, dob, startDate, trainer);
                    obj.add(pm);
                    JOptionPane.showMessageDialog(frame1, "Premium member added successfully.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "ID must be a number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error adding Premium member: " + ex.getMessage());
            }
        }
        
        // Revert Regular Member
        if (oh == revertregular) {
            try {
                int id = Integer.parseInt(regularidtextfield.getText().trim());
                String reason = remReasonField.getText().trim();
                if (reason.isEmpty()) {
                    JOptionPane.showMessageDialog(frame1, "Please enter a removal reason");
                    return;
                }
                
                boolean found = false;
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof RegularMember) {
                        ((RegularMember)m).RevertRegularMember(reason);
                        JOptionPane.showMessageDialog(frame1, "Regular member has been reverted");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Regular member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error reverting Regular member: " + ex.getMessage());
            }
        }
        
        // Revert Premium Member
        if (oh == revertpremium) {
            try {
                int id = Integer.parseInt(premiumidtextfield.getText().trim());
                boolean found = false;
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof PremiumMember) {
                        ((PremiumMember)m).RevertPremiumMember();
                        JOptionPane.showMessageDialog(frame1, "Premium member has been reverted");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Premium member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error reverting Premium member: " + ex.getMessage());
            }
        }
        
        // Remove Regular Member
        if (oh == removeregular) {
            try {
                int id = Integer.parseInt(regularidtextfield.getText().trim());
                boolean found = false;
                for (Iterator<GymMember> iterator = obj.iterator(); iterator.hasNext();) {
                    GymMember m = iterator.next();
                    if (m.getId() == id && m instanceof RegularMember) {
                        iterator.remove();
                        JOptionPane.showMessageDialog(frame1, "Regular member has been removed");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Regular member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error removing Regular member: " + ex.getMessage());
            }
        }
        
        // Remove Premium Member
        if (oh == removepremium) {
            try {
                int id = Integer.parseInt(premiumidtextfield.getText().trim());
                boolean found = false;
                for (Iterator<GymMember> iterator = obj.iterator(); iterator.hasNext();) {
                    GymMember m = iterator.next();
                    if (m.getId() == id && m instanceof PremiumMember) {
                        iterator.remove();
                        JOptionPane.showMessageDialog(frame1, "Premium member has been removed");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Premium member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error removing Premium member: " + ex.getMessage());
            }
        }
        
        // Activate Regular Membership
        if (oh == activeregular) {
            try {
                int id = Integer.parseInt(regularidtextfield.getText().trim());
                boolean found = false;
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof RegularMember) {
                        found = true;
                        m.ActivateMembership();
                        JOptionPane.showMessageDialog(frame1, "Regular Membership is Activated");
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Regular member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error activating Regular membership: " + ex.getMessage());
            }
        }
        
        // Activate Premium Membership
        if (oh == activepremium) {
            try {
                int id = Integer.parseInt(premiumidtextfield.getText().trim());
                boolean found = false;
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof PremiumMember) {
                        found = true;
                        m.ActivateMembership();
                        JOptionPane.showMessageDialog(frame1, "Premium Membership is Activated");
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Premium member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error activating Premium membership: " + ex.getMessage());
            }
        }
        
        // Deactivate Regular Membership
        if (oh == deactiveregular) {
            try {
                int id = Integer.parseInt(regularidtextfield.getText().trim());
                boolean found = false;
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof RegularMember) {
                        found = true;
                        m.DeactivateMembership();
                        JOptionPane.showMessageDialog(frame1, "Regular Membership is Deactivated");
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Regular member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error deactivating Regular membership: " + ex.getMessage());
            }
        }
        
        // Deactivate Premium Membership
        if (oh == deactivepremium) {
            try {
                int id = Integer.parseInt(premiumidtextfield.getText().trim());
                boolean found = false;
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof PremiumMember) {
                        found = true;
                        m.DeactivateMembership();
                        JOptionPane.showMessageDialog(frame1, "Premium Membership is Deactivated");
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Premium member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error deactivating Premium membership: " + ex.getMessage());
            }
        }
        
        // Mark Attendance for Regular Member
        if (oh == attendaceregular) {
            try {
                int id = Integer.parseInt(regularidtextfield.getText().trim());
                boolean found = false;
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof RegularMember) {
                        found = true;
                        if (m.getActiveStatus()) {
                            ((RegularMember)m).MarkAttendance();
                            JOptionPane.showMessageDialog(frame1, "Attendance marked for Regular member");
                        } else {
                            JOptionPane.showMessageDialog(frame1, "Member needs to be activated first");
                        }
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Regular member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error marking Regular attendance: " + ex.getMessage());
            }
        }
        
        // Mark Attendance for Premium Member
        if (oh == attendacepremium) {
            try {
                int id = Integer.parseInt(premiumidtextfield.getText().trim());
                boolean found = false;
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof PremiumMember) {
                        found = true;
                        if (m.getActiveStatus()) {
                            ((PremiumMember)m).MarkAttendance();
                            JOptionPane.showMessageDialog(frame1, "Attendance marked for Premium member");
                        } else {
                            JOptionPane.showMessageDialog(frame1, "Member needs to be activated first");
                        }
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Premium member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error marking Premium attendance: " + ex.getMessage());
            }
        }
        
        // Display Regular Members
        if (oh == displayregular) {
            try {
                StringBuilder display = new StringBuilder();
                boolean found = false;
                
                if (!regularidtextfield.getText().trim().isEmpty()) {
                    int id = Integer.parseInt(regularidtextfield.getText().trim());
                    for (GymMember m : obj) {
                        if (m.getId() == id && m instanceof RegularMember) {
                            display.append(getMemberDisplay(m));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(frame1, "Regular member ID not found");
                        return;
                    }
                } else {
                    for (GymMember m : obj) {
                        if (m instanceof RegularMember) {
                            display.append(getMemberDisplay(m)).append("\n\n");
                            found = true;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(frame1, "No Regular members found");
                        return;
                    }
                }
                
                JTextArea textArea = new JTextArea(display.toString());
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(600, 400));
                JOptionPane.showMessageDialog(frame1, scrollPane, "Regular Member Details", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error displaying Regular members: " + ex.getMessage());
            }
        }
        
        // Display Premium Members
        if (oh == displaypremium) {
            try {
                StringBuilder display = new StringBuilder();
                boolean found = false;
                
                if (!premiumidtextfield.getText().trim().isEmpty()) {
                    int id = Integer.parseInt(premiumidtextfield.getText().trim());
                    for (GymMember m : obj) {
                        if (m.getId() == id && m instanceof PremiumMember) {
                            display.append(getMemberDisplay(m));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(frame1, "Premium member ID not found");
                        return;
                    }
                } else {
                    for (GymMember m : obj) {
                        if (m instanceof PremiumMember) {
                            display.append(getMemberDisplay(m)).append("\n\n");
                            found = true;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(frame1, "No Premium members found");
                        return;
                    }
                }
                
                JTextArea textArea = new JTextArea(display.toString());
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(600, 400));
                JOptionPane.showMessageDialog(frame1, scrollPane, "Premium Member Details", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error displaying Premium members: " + ex.getMessage());
            }
        }
        
        // Upgrade Regular Plan
        if (oh == upregular) {
            try {
                int id = Integer.parseInt(regularidtextfield.getText().trim());
                String selectedPlan = ((String)Plan1.getSelectedItem()).split(" = ")[0];
                boolean found = true;
                
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof RegularMember) {
                        found = false;
                        if (m.getActiveStatus()) {
                            String result = ((RegularMember)m).Upgradeplan(selectedPlan);
                            JOptionPane.showMessageDialog(frame1, result);
                        } else {
                            JOptionPane.showMessageDialog(frame1, "Member must be active to upgrade plan");
                        }
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Regular member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error upgrading plan: " + ex.getMessage());
            }
        }
        
        // Upgrade Premium Plan (not applicable, show message)
        if (oh == uppremium) {
            try {
                int id = Integer.parseInt(premiumidtextfield.getText().trim());
                boolean found = false;
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof PremiumMember) {
                        found = true;
                        JOptionPane.showMessageDialog(frame1, "Plan upgrade not available for Premium members");
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Premium member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error upgrading plan: " + ex.getMessage());
            }
        }
        
        // Pay Due Amount for Premium Member
      if (oh == payremain) {
      try {
        int id = Integer.parseInt(premiumidtextfield.getText().trim());
        String amountText = plan2.getText().trim();
        if (amountText.isEmpty()) {
            JOptionPane.showMessageDialog(frame1, "Please enter an amount to pay");
            return;
        }
        double amount = Double.parseDouble(amountText);
        if (amount <= 0) {
            JOptionPane.showMessageDialog(frame1, "Payment amount must be positive");
            return;
        }
        boolean found = false;
        for (GymMember m : obj) {
            if (m.getId() == id && m instanceof PremiumMember) {
                found = true;
                String result = ((PremiumMember)m).PayDueAmount(amount);
                JOptionPane.showMessageDialog(frame1, result);
                plan2.setText("");
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(frame1, "Premium member ID not found");
        }
        } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame1, "Please enter a valid number for paying amount");
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(frame1, "Error processing payment: " + ex.getMessage());
       }
        }
        
        // Read Regular Members from File
        if (oh == readregular) {
            try {
                File file = new File("MemberDetails.txt");
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(frame1, "MemberDetails.txt not found");
                    return;
                }
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                boolean found = false;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("ID") || line.trim().isEmpty()) continue;
                    String[] data = line.trim().split("\\s+");
                    if (data.length >= 11 && !data[10].equals("true") && !data[10].equals("false")) { // Check for Regular member format
                        try {
                            int id = Integer.parseInt(data[0]);
                            String name = data[1];
                            String location = data[2];
                            String phone = data[3];
                            String email = data[4];
                            String gender = data[5];
                            String dob = data[6] + " " + data[7] + " " + data[8];
                            String startDate = data[9];
                            String referral = data[10];
                            RegularMember rm = new RegularMember(id, name, location, phone, email, gender, dob, startDate, referral);
                            obj.add(rm);
                            found = true;
                        } catch (Exception ex) {
                            // Skip malformed lines
                        }
                    }
                }
                br.close();
                if (found) {
                    JOptionPane.showMessageDialog(frame1, "Regular members loaded from MemberDetails.txt");
                } else {
                    JOptionPane.showMessageDialog(frame1, "No Regular members found in file");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame1, "Error reading Regular members: " + ex.getMessage());
            }
        }
        
        // Read Premium Members from File
        if (oh == readpremium) {
            try {
                File file = new File("MemberDetails.txt");
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(frame1, "MemberDetails.txt not found");
                    return;
                }
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                boolean found = false;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("ID") || line.trim().isEmpty()) continue;
                    String[] data = line.trim().split("\\s+");
                    if (data.length >= 12) { // Check for Premium member format
                        try {
                            int id = Integer.parseInt(data[0]);
                            String name = data[1];
                            String location = data[2];
                            String phone = data[3];
                            String email = data[4];
                            String gender = data[5];
                            String dob = data[6] + " " + data[7] + " " + data[8];
                            String startDate = data[9];
                            String trainer = data[10];
                            PremiumMember pm = new PremiumMember(id, name, location, phone, email, gender, dob, startDate, trainer);
                            obj.add(pm);
                            found = true;
                        } catch (Exception ex) {
                            // Skip malformed lines
                        }
                    }
                }
                br.close();
                if (found) {
                    JOptionPane.showMessageDialog(frame1, "Premium members loaded from MemberDetails.txt");
                } else {
                    JOptionPane.showMessageDialog(frame1, "No Premium members found in file");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame1, "Error reading Premium members: " + ex.getMessage());
            }
        }
        
        // Save Regular Members to File
        if (oh == saveregular) {
            try {
                File file = new File("MemberDetails.txt");
                FileWriter fw = new FileWriter(file);
                
                fw.write(String.format("%-5s %-15s %-15s %-15s %-25s %-10s %-15s %-15s %-10s %-10s %-15s\n",
                    "ID", "Name", "Location", "Phone", "Email", "Gender", "DOB", "StartDate", "Attend", "Loyalty", "Active"));
                
                boolean found = false;
                for (GymMember m : obj) {
                    if (m instanceof RegularMember) {
                        RegularMember rm = (RegularMember)m;
                        fw.write(String.format("%-5d %-15s %-15s %-15s %-25s %-10s %-15s %-15s %-10d %-10.2f %-15b\n",
                            rm.getId(), rm.getName(), rm.getLocation(), rm.getPhone(), rm.getEmail(),
                            rm.getGender(), rm.getDateOfBirth(), rm.getMembershipStartDate(),
                            rm.getAttendance(), rm.getLoyaltyPoints(), rm.getActiveStatus()));
                        found = true;
                    }
                }
                
                fw.close();
                if (found) {
                    JOptionPane.showMessageDialog(frame1, "Regular member details saved to MemberDetails.txt");
                } else {
                    JOptionPane.showMessageDialog(frame1, "No Regular members to save");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame1, "Error saving Regular members: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error saving Regular members: " + ex.getMessage());
            }
        }
        
        // Save Premium Members to File
        if (oh == savepremium) {
            try {
                File file = new File("MemberDetails.txt");
                FileWriter fw = new FileWriter(file, true);
                
                fw.write(String.format("%-5s %-15s %-15s %-15s %-25s %-10s %-15s %-15s %-15s %-10s %-15s %-15s\n",
                    "ID", "Name", "Location", "Phone", "Email", "Gender", "DOB", "StartDate", "Trainer", "Paid", "FullPay", "Active"));
                
                boolean found = false;
                for (GymMember m : obj) {
                    if (m instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember)m;
                        fw.write(String.format("%-5d %-15s %-15s %-15s %-25s %-10s %-15s %-15s %-15s %-10.2f %-15b %-15b\n",
                            pm.getId(), pm.getName(), pm.getLocation(), pm.getPhone(), pm.getEmail(),
                            pm.getGender(), pm.getDateOfBirth(), pm.getMembershipStartDate(),
                            pm.getPersonalTrainer(), pm.getPaidAmount(), pm.isFullPayment(), pm.getActiveStatus()));
                        found = true;
                    }
                }
                
                fw.close();
                if (found) {
                    JOptionPane.showMessageDialog(frame1, "Premium member details saved to MemberDetails.txt");
                } else {
                    JOptionPane.showMessageDialog(frame1, "No Premium members to save");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame1, "Error saving Premium members: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error saving Premium members: " + ex.getMessage());
            }
        }

        // Calculate Discount for Premium Member
        if (oh == calculated) {
            try {
                int id = Integer.parseInt(premiumidtextfield.getText().trim());
                boolean found = false;
                for (GymMember m : obj) {
                    if (m.getId() == id && m instanceof PremiumMember) {
                        found = true;
                        PremiumMember pm = (PremiumMember)m;
                        pm.CalculateDiscount();
                        JOptionPane.showMessageDialog(frame1, "Discount calculated: " + pm.getDiscountAmount());
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(frame1, "Premium member ID not found");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame1, "Please enter a valid ID number");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame1, "Error calculating discount: " + ex.getMessage());
            }
        }
    }
    
    // Helper method to capture display output
    private String getMemberDisplay(GymMember m) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        
        try {
            if (m instanceof RegularMember) {
                ((RegularMember)m).display();
            } else if (m instanceof PremiumMember) {
                ((PremiumMember)m).display();
            } else {
                return "Invalid member type";
            }
        } finally {
            System.out.flush();
            System.setOut(old);
        }
        
        return baos.toString();
    }
    
    public void a1()
    {
        frame1 = new JFrame();
        frame1.setTitle("GYM FORM");
        frame1.setSize(1150, 700);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        font1 = new Font("Arial", Font.BOLD, 25);
        font2 = new Font("Arial", Font.BOLD, 20);
        font3 = new Font("Arial", Font.PLAIN, 15);
        color1 = new Color(191, 191, 191);
    
        panel1 = new JPanel();
        panel1.setBounds(0, 0, 1150, 700);
        panel1.setBackground(color1);
        panel1.setLayout(null);
        frame1.add(panel1);
        
        label1 = new JLabel("Sworup Fitness Club");
        label1.setBounds(450, 15, 300, 50);
        label1.setFont(font1);
        panel1.add(label1);
        
        detail1 = new JLabel("Regular Membership");
        detail1.setBounds(465, 40, 450, 55);
        detail1.setFont(font2);
        panel1.add(detail1);
        
        Regularid = new JLabel("ID");
        Regularid.setBounds(10, 100, 100, 50);
        Regularid.setFont(font3);
        panel1.add(Regularid);

        regularidtextfield = new JTextField();
        regularidtextfield.setBounds(200, 110, 200, 25);
        panel1.add(regularidtextfield);
        
        regularemail1 = new JLabel("Email");
        regularemail1.setBounds(500, 100, 200, 50);
        regularemail1.setFont(font3);
        panel1.add(regularemail1);

        regulartextemail = new JTextField();
        regulartextemail.setBounds(650, 110, 200, 25);
        panel1.add(regulartextemail);
        
        regularname1 = new JLabel("Name");
        regularname1.setBounds(10, 150, 200, 50);
        regularname1.setFont(font3);
        panel1.add(regularname1);

        regulartextname = new JTextField();
        regulartextname.setBounds(200, 160, 200, 25);
        panel1.add(regulartextname);
        
        regularlocation1 = new JLabel("Location");
        regularlocation1.setBounds(500, 150, 100, 50);
        regularlocation1.setFont(font3);
        panel1.add(regularlocation1);

        regulartextlocation = new JTextField();
        regulartextlocation.setBounds(650, 160, 200, 25);
        panel1.add(regulartextlocation);
        
        regularphone1 = new JLabel("Phone");
        regularphone1.setBounds(10, 200, 200, 50);
        regularphone1.setFont(font3);
        panel1.add(regularphone1);

        regulartextphone = new JTextField();
        regulartextphone.setBounds(200, 210, 200, 25);
        panel1.add(regulartextphone);
                
        regulargender1 = new JLabel("Gender");
        regulargender1.setBounds(500, 200, 200, 50);
        regulargender1.setFont(font3);
        panel1.add(regulargender1);

        regularmale = new JRadioButton("Male");
        regularmale.setBounds(650, 210, 90, 30);
        panel1.add(regularmale);

        regularfemale = new JRadioButton("Female");
        regularfemale.setBounds(750, 210, 90, 30);
        panel1.add(regularfemale);

        regularbg = new ButtonGroup(); 
        regularbg.add(regularmale);
        regularbg.add(regularfemale);
        
        regularstartdate1 = new JLabel("Membership Start Date:");
        regularstartdate1.setBounds(10, 250, 200, 50);
        regularstartdate1.setFont(font3);
        panel1.add(regularstartdate1);

        regulardate = new JComboBox(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", 
                "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        regulardate.setBounds(200, 260, 65, 40);
        panel1.add(regulardate); 

        regularmonth = new JComboBox(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", 
                "September", "October", "November", "December"});
        regularmonth.setBounds(265, 260, 80, 40);
        panel1.add(regularmonth);

        regularyear = new JComboBox(new String[] {"2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015"}); 
        regularyear.setBounds(355, 260, 70, 40);
        panel1.add(regularyear);
        
        regulardob1 = new JLabel("DOB");
        regulardob1.setBounds(500, 250 , 180 , 50 );
        regulardob1.setFont(font3);
        panel1.add(regulardob1);

        regulardobdate = new JComboBox(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", 
                "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        regulardobdate.setBounds(650, 250, 65, 40);
        panel1.add(regulardobdate); 

        regulardobmonth = new JComboBox(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", 
                "September", "October", "November", "December"});
        regulardobmonth.setBounds(720, 250, 80, 40);
        panel1.add(regulardobmonth);

        regulardobyear = new JComboBox(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", 
                "2007", "2008", "2009"}); 
        regulardobyear.setBounds(800, 250 , 70, 40);
        panel1.add(regulardobyear);
        
        regularsource1 = new JLabel("Referral Source");
        regularsource1.setBounds(10, 300, 200, 50);
        regularsource1.setFont(font3);
        panel1.add(regularsource1);

        regulartextsource = new JTextField();
        regulartextsource.setBounds(200,310, 200, 25);
        panel1.add(regulartextsource);
        
        JLabel plan1 = new JLabel("The Plan:");
        plan1.setBounds(500, 300, 200, 50);
        plan1.setFont(font3);
        panel1.add(plan1);

        Plan1 = new JComboBox(new String[] {"Basic", "Standard", "Deluxe"}); 
        Plan1.setBounds(650, 300, 80, 50);
        panel1.add(Plan1);
        
        clearregular= new JButton("Clear");
        clearregular.setBounds(750, 300, 200, 50);
        clearregular.addActionListener(this);
        panel1.add(clearregular);

        addregular= new JButton("Input Regular Member");
        addregular.setBounds(10, 400, 200, 50);
        addregular.addActionListener(this);
        panel1.add(addregular);

        revertregular= new JButton("Revert a Regular Member");
        revertregular.setBounds(300, 400, 200, 50);
        revertregular.addActionListener(this);
        panel1.add(revertregular);
        
        remReasonField = new JTextField();
        remReasonField.setBounds(600, 400, 250, 50);
        panel1.add(remReasonField);
        
        upregular= new JButton("Upgrade The Plan");
        upregular.setBounds(900, 400, 200, 50);
        upregular.addActionListener(this);
        panel1.add(upregular);
        
        activeregular= new JButton("Activate Regular Membership");
        activeregular.setBounds(10, 470, 200, 50);
        activeregular.addActionListener(this);
        panel1.add(activeregular);

        removeregular= new JButton("Remove Regular Membership");
        removeregular.setBounds(300, 470, 200, 50);
        removeregular.addActionListener(this);
        panel1.add(removeregular);

        displayregular= new JButton("Display");
        displayregular.setBounds(600, 470, 200, 50);
        displayregular.addActionListener(this);
        panel1.add(displayregular);
        
        changetopremium= new JButton("Change to Premium Member");
        changetopremium.setBounds(900, 470, 200, 50);
        changetopremium.addActionListener(this);
        panel1.add(changetopremium);

        deactiveregular= new JButton("Deactivate the Membership");
        deactiveregular.setBounds(10, 540, 200, 50);
        deactiveregular.addActionListener(this);
        panel1.add(deactiveregular);

        attendaceregular= new JButton("Mark Attendance");
        attendaceregular.setBounds(300, 540, 200, 50);
        attendaceregular.addActionListener(this);
        panel1.add(attendaceregular);
        
        readregular= new JButton("Read from The File");
        readregular.setBounds(600, 540, 200, 50);
        readregular.addActionListener(this);
        panel1.add(readregular);

        saveregular= new JButton("Save to The File");
        saveregular.setBounds(900, 540, 200, 50);
        saveregular.addActionListener(this);
        panel1.add(saveregular);

        frame1.setVisible(true);
    }
    
    public void a2()
    {
        frame1 = new JFrame();
        frame1.setTitle("GYM Premium FORM");
        frame1.setSize(1150, 700);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        font1 = new Font("Arial", Font.BOLD, 25);
        font2 = new Font("Arial", Font.BOLD, 20);
        font3 = new Font("Arial", Font.PLAIN, 15);
        color1 = new Color(191, 191, 191);
        
        panel1 = new JPanel();
        panel1.setBounds(0, 0, 1150, 700);
        panel1.setBackground(color1);
        panel1.setLayout(null);
        frame1.add(panel1);
        
        label1 = new JLabel("Sworup Fitness Club");
        label1.setBounds(450, 15, 300, 50);
        label1.setFont(font1);
        panel1.add(label1);
        
        detail1 = new JLabel("Premium Membership");
        detail1.setBounds(465, 40, 450, 55);
        detail1.setFont(font2);
        panel1.add(detail1);
        
        Premiumid = new JLabel("ID");
        Premiumid.setBounds(10, 100, 100, 50);
        Premiumid.setFont(font3);
        panel1.add(Premiumid);
        
        premiumidtextfield = new JTextField();
        premiumidtextfield.setBounds(200, 110, 200, 25);
        panel1.add(premiumidtextfield);
        
        premiumemail = new JLabel("Email:");
        premiumemail.setBounds(500, 100, 200, 50);
        premiumemail.setFont(font3);
        panel1.add(premiumemail);

        premiumtextemail = new JTextField();
        premiumtextemail.setBounds(650, 110, 200, 25);
        panel1.add(premiumtextemail);
        
        premiumname = new JLabel("Name:");
        premiumname.setBounds(10, 150, 200, 50);
        premiumname.setFont(font3);
        panel1.add(premiumname);

        premiumtextname = new JTextField();
        premiumtextname.setBounds(200, 160, 200, 25);
        panel1.add(premiumtextname);
        
        premiumlocation = new JLabel("Location:");
        premiumlocation.setBounds(500, 150, 100, 50);
        premiumlocation.setFont(font3);
        panel1.add(premiumlocation);
        
        premiumtextlocation = new JTextField();
        premiumtextlocation.setBounds(650, 160, 200, 25);
        panel1.add(premiumtextlocation);
        
        premiumphone = new JLabel("Phone:");
        premiumphone.setBounds(10, 200, 200, 50);
        premiumphone.setFont(font3);
        panel1.add(premiumphone);

        premiumtextphone = new JTextField();
        premiumtextphone.setBounds(200, 210, 200, 25);
        panel1.add(premiumtextphone);
        
        premiumgender = new JLabel("Gender:");
        premiumgender.setBounds(500, 200, 200, 50);
        premiumgender.setFont(font3);
        panel1.add(premiumgender);

        premiummale = new JRadioButton("Male");
        premiummale.setBounds(650, 210, 90, 30);
        panel1.add(premiummale);

        premiumfemale = new JRadioButton("Female");
        premiumfemale.setBounds(750, 210, 90, 30);
        panel1.add(premiumfemale);

        premiumbg = new ButtonGroup();
        premiumbg.add(premiummale);
        premiumbg.add(premiumfemale);
        
        premiumStartDate2 = new JLabel("Membership Start Date:");
        premiumStartDate2.setBounds(10, 250, 200, 50);
        premiumStartDate2.setFont(font3);
        panel1.add(premiumStartDate2);

        premiumdate = new JComboBox(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", 
                "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        premiumdate.setBounds(200, 260, 65, 40);
        panel1.add(premiumdate); 

        premiummonth = new JComboBox(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", 
                "September", "October", "November", "December"});
        premiummonth.setBounds(265, 260, 80, 40);
        panel1.add(premiummonth);

        premiumyear = new JComboBox(new String[] {"2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015"}); 
        premiumyear.setBounds(355, 260, 70, 40);
        panel1.add(premiumyear);
        
        premiumdob = new JLabel("DOB:");
        premiumdob.setBounds(500, 250 , 180 , 50 );
        premiumdob.setFont(font3);
        panel1.add(premiumdob);

        premiumdobdate = new JComboBox(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", 
                "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        premiumdobdate.setBounds(650, 250, 65, 40);
        panel1.add(premiumdobdate); 

        premiumdobmonth = new JComboBox(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", 
                "September", "October", "November", "December"});
        premiumdobmonth.setBounds(720, 250, 80, 40);
        panel1.add(premiumdobmonth);

        premiumdobyear = new JComboBox(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", 
                "2007", "2008", "2009"});
        premiumdobyear.setBounds(800, 250 , 70, 40);
        panel1.add(premiumdobyear);
        
        premiumtrainer = new JLabel("Trainer Name:");
        premiumtrainer.setBounds(10, 300, 200, 50);
        premiumtrainer.setFont(font3);
        panel1.add(premiumtrainer);

        premiumtexttrainer = new JTextField();
        premiumtexttrainer.setBounds(200,310, 200, 25);
        panel1.add(premiumtexttrainer);
        
        JLabel plan1 = new JLabel("Pay Amount:");
        plan1.setBounds(500, 300, 200, 50);
        plan1.setFont(font3);
        panel1.add(plan1);
        
        plan2 = new JTextField();
        plan2.setBounds(650, 300, 100, 50);
        panel1.add(plan2);
        
        clearpremium= new JButton("Clear");
        clearpremium.setBounds(800, 300, 200, 50);
        clearpremium.addActionListener(this);
        panel1.add(clearpremium);
        
        addpremium= new JButton("Input Premium Member");
        addpremium.setBounds(10, 400, 200, 50);
        addpremium.addActionListener(this);
        panel1.add(addpremium);
        
        revertpremium= new JButton("Revert a Premium Member");
        revertpremium.setBounds(300, 400, 200, 50);
        revertpremium.addActionListener(this);
        panel1.add(revertpremium);
        
        payremain= new JButton("Remaining amount");
        payremain.setBounds(600, 400, 200, 50);
        payremain.addActionListener(this);
        panel1.add(payremain);
        
        uppremium= new JButton("Upgrade Plan");
        uppremium.setBounds(900, 400, 200, 50);
        uppremium.addActionListener(this);
        panel1.add(uppremium);
        
        activepremium= new JButton("Activate Premium Membership");
        activepremium.setBounds(10, 470, 200, 50);
        activepremium.addActionListener(this);
        panel1.add(activepremium);
        
        removepremium= new JButton("Remove Premium Membership");
        removepremium.setBounds(300, 470, 200, 50);
        removepremium.addActionListener(this);
        panel1.add(removepremium);
        
        displaypremium= new JButton("Display");
        displaypremium.setBounds(600, 470, 200, 50);
        displaypremium.addActionListener(this);
        panel1.add(displaypremium);
        
        changetoregular= new JButton("Change to Regular Member");
        changetoregular.setBounds(900, 470, 200, 50);
        changetoregular.addActionListener(this);
        panel1.add(changetoregular);
        
        deactivepremium= new JButton("Deactivate Premium Membership");
        deactivepremium.setBounds(10, 540, 200, 50);
        deactivepremium.addActionListener(this);
        panel1.add(deactivepremium);
        
        attendacepremium= new JButton("Mark Attendance");
        attendacepremium.setBounds(300, 540, 200, 50);
        attendacepremium.addActionListener(this);
        panel1.add(attendacepremium);
        
        readpremium= new JButton("Read from File");
        readpremium.setBounds(600, 540, 200, 50);
        readpremium.addActionListener(this);
        panel1.add(readpremium);
        
        savepremium= new JButton("Save to File");
        savepremium.setBounds(900, 540, 200, 50);
        savepremium.addActionListener(this);
        panel1.add(savepremium);
        
        calculated= new JButton("Calculate the Discount");
        calculated.setBounds(450, 600, 200, 50);
        calculated.addActionListener(this);
        panel1.add(calculated);
        
        frame1.setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            GymGUI obj = new GymGUI();
            obj.showWelcomeScreen();
        });
    }
    
    // Added welcome screen to match coursework requirements
    private void showWelcomeScreen() {
        frame1 = new JFrame("Gym Management System");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(300, 200);
        frame1.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("Welcome to Sworup Gym CLUB", SwingConstants.CENTER);
        panel.add(welcomeLabel);

        RegularMember = new JButton("Regular Member");
        RegularMember.addActionListener(this);
        panel.add(RegularMember);

        PremiumMember = new JButton("Premium Member");
        PremiumMember.addActionListener(this);
        panel.add(PremiumMember);

        frame1.add(panel);
        frame1.setVisible(true);
    }
}