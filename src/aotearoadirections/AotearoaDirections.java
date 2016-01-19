/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aotearoadirections;

//All Import Documentation were written while programming. 
import java.awt.BorderLayout; //import for border layouts
import java.awt.Color; //import for color
import java.awt.FlowLayout; //import for flow layout
import java.awt.Font; //import for fonts. 
import java.awt.GridLayout; //import for grid layout
import java.awt.event.ActionEvent; //import for action events. 
import java.awt.event.ActionListener; //import for action listener
import java.awt.event.KeyEvent; //import for keyboard movement 
import java.awt.event.KeyListener; //import for key listener
import java.awt.event.MouseEvent; //import of mouse movement
import java.awt.event.MouseListener; //import for mouse listener
import java.awt.event.MouseMotionListener; //import for mouse motion listener
import java.awt.event.WindowAdapter; //import for window adapter. 
import javax.swing.JFrame; //import for using JFrames. 
import java.text.*;  //import for reading in and out of a file. 
import java.io.*; //import for buffered reader and an option thing popping up.
import java.util.logging.Level; //import for util logger
import java.util.logging.Logger; //import for util logger.logger...
import javax.swing.ImageIcon; //import for imageIcon (in order to add a picture)
import javax.swing.JButton; //import for using jbuttons
import javax.swing.JComponent; //import for jcomponent.
import javax.swing.JLabel; //import for JLabel. 
import javax.swing.JList; //import for jlist
import javax.swing.JPanel; //import for using jpanels
import javax.swing.JScrollPane; //import for using jscroll pane. 
import javax.swing.JTextArea; //impot for JText Area
import javax.swing.JTextField; //import for JText Field
import java.awt.event.WindowEvent;  //window event 
import javax.swing.JOptionPane; //import for joptionpane
import javax.swing.WindowConstants; //import for WindowEvents

/**Aotearoa Directions
 * 
 * For Ryk Skelton
 * 
 * Start Date: February 27th, 2013
 * 
 * End Date: April 15th, 2013. 
 * 
 * To put into context, all the documentation at the end of brace brackets and before groups of 
 *
 * @author nataliechin
 */
public class AotearoaDirections implements MouseListener, MouseMotionListener, KeyListener, ActionListener
{

    BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
    //BufferedReader in = new BufferedReader(new FileReader("Macintosh HD/Users/nataliechin/NetBeans Project/AotearoaDirections/src/aotearoadirections/maps")); 
    BufferedReader infile = new BufferedReader(new FileReader("Directions.txt")); //tells the program to read from accommodation.txt (AW)
    
    //Declaration for Colors: 
    
        Color darkBlue = new Color(0, 0, 255);
        Color red = new Color (255, 3, 3);
    
    Directions direct [] = new Directions[100];
    
    //declaration for font
    
    Font mainFont = new Font("Sans-Serif", Font.PLAIN , 16); 
    Font titleFont = new Font("Sans-Serif", Font.BOLD, 20);    
    
    int positionInArray; 
    
    boolean tracing = true;
    boolean ny = true; 
    
    int x = -1; 
    
        JButton instructions = new JButton("Instructions");
        JButton menu = new JButton("Menu");    
        JButton addEntry = new JButton("Add Entry");
        JButton seeEntry = new JButton ("See Entries");   
        
        JButton goBackMenu = new JButton("Return to Menu");
        JButton reset = new JButton("Reset Form");
        
        JTextArea blurbField = new JTextArea();
            JScrollPane b = new JScrollPane(blurbField);
        JTextField startField = new JTextField(); 
            JScrollPane s = new JScrollPane(startField);
        JTextField destinationField = new JTextField();    
            JScrollPane di = new JScrollPane(destinationField);
        JTextField dateField = new JTextField();
            JScrollPane da = new JScrollPane(dateField);
        JTextField durationField  = new JTextField();
        JTextArea directionsField = new JTextArea();
            JScrollPane d = new JScrollPane(directionsField);        
    
        JButton continueAdd = new JButton("Continue");
        
        JTextField startingSeeEntry = new JTextField();
            JScrollPane startSee = new JScrollPane(startingSeeEntry);
        JTextField destinationSeeEntry = new JTextField();
            JScrollPane destSee = new JScrollPane(destinationSeeEntry);
        JTextField dateSeeEntry = new JTextField();
            JScrollPane dateSee = new JScrollPane(dateSeeEntry);
        JButton continueSeeEntry = new JButton("Continue");
        JButton continueAddEntry = new JButton("Add Entry");
        JButton continueMenu = new JButton("Menu");
        int seeEntryDisplay; 
        int seeEntryDisplaying = -1; 
        
        JButton leaveMenu = new JButton("Return to Menu");
            
         
    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) throws IOException
    {
        new AotearoaDirections();
    } //end of main method
    
    AotearoaDirections() throws IOException
    {
        readFromFile();
        kiaOra();
    } //end of Aotearoa Directions
    
    /**************************************************************************************************************************************
     * Description of Method: Reads all the information in from the file.
     * Parameters and Return Type: None. 
     * Pre conditions: JButons must exist in class.
     * Post conditions: The program now contains what is in the file.
     * ************************************************************************************************************************************
     */      
    
    private void readFromFile() throws FileNotFoundException, IOException 
    {   
        positionInArray = Integer.parseInt(infile.readLine());
            //making positionInArray into the first number in the file
        
            if (tracing) System.out.println("Before Creating Object, value of PIA is: " + positionInArray); //displaying positionInArray because positionInArray kept messing up
            
            
        for (int counter = 0; counter<=positionInArray; counter++) //this line of code goes through the loop and makes new objects. 
        {
              direct[counter] = new Directions();   
              if (tracing) System.out.println("While creating object, value of PIA is: " + positionInArray);
        }
        
              if (tracing) System.out.println("Outside creating object, value of PIA is: "+positionInArray);
            
        
        for (int index = 0; index<=positionInArray; index++)
        {
            String temp; 
            
            if (tracing) System.out.println("After entering the second for loop, value of PIA is:  " +positionInArray+ ".");
            
            /*String temporary = infile.readLine(); //make the thing on the first line equal to a string (AW)
            if (tracing) System.out.print(temporary);           
                direct[index].startingLocation = temporary; //puts the string into the thing at positionInArray (start bubble) (AW)
            if (tracing)         System.out.print(direct[index].startingLocation);
            */ 

            temp = infile.readLine().trim(); //make the same string equal to th 2nd line in the file (AW)
            if (tracing) System.out.println(temp);
            direct[index].startingLocation = temp; //puts the string into the thing at positionInArray (destination bubble) (AW)
            if (tracing)         System.out.println(direct[index].startingLocation);

            temp = infile.readLine().trim(); //makes string equal to the 3rd line in the file (AW)
            if (tracing) System.out.println(temp);
            direct[index].destination = temp; //puts the string into the thing at positionInArray (blurb bubble) (AW)
            if (tracing) System.out.println(direct[index].destination);
            
            temp  = infile.readLine().trim(); //makes temp equal to the 4th line in the file (AW)
            if (tracing) System.out.println(temp);
            direct[index].date = temp;  //puts the type into the thing at positionInArray (duration bubble) (AW)
            if (tracing)         System.out.println(direct[index].date);              
            
            temp = infile.readLine().trim(); //make the same string equal to th 2nd line in the file (AW)
            if (tracing) System.out.println(temp);
            direct[index].blurb = temp; //puts the string into the thing at positionInArray (destination bubble) (AW)
            if (tracing)         System.out.println(direct[index].blurb);
            
            temp = infile.readLine().trim(); //makes the string equal to the 5th line.  (AW)
            if (tracing) System.out.println(temp);
            direct[index].duration = temp; //puts the string into the thing at positionInArray (info bubble) (AW)
            if (tracing)         System.out.println(direct[index].duration); 
            
            temp = infile.readLine().trim(); //makes the string equal to the 5th line.  (AW)
            if (tracing) System.out.println(temp);
            direct[index].directions = temp; //puts the string into the thing at positionInArray (info bubble) (AW)
            if (tracing)         System.out.println(direct[index].directions); 
        } //end of for loop
        
        infile.close();
        
        if (tracing) System.out.print("End of readFromFile method positionInArray"+positionInArray);        
    } //end of readFromFile();
    
    /**************************************************************************************************************************************
     * Description of Method: After entering the information into the program, it writes it to the file so that one can always refer back to old inputs.  
     * Parameters and Return Type: None. 
     * Pre conditions: Must have been called from another class. Program should have created a JButton to create this. 
     * Post conditions: Would have printed everything into the array of objects into the text file. 
     * ************************************************************************************************************************************
     */      
    
    public void writeToFile() throws IOException
    {
        String fileName = "Directions.txt";
        
        PrintWriter outfile = new PrintWriter (new FileWriter(fileName)); //declares the print to file line of code (AW)
        outfile.println(positionInArray);      //print the positionInArray as the first step (AW)
        if (tracing) System.out.println(positionInArray);
        
        if (tracing) 
        {
            System.out.println(positionInArray);
            System.out.println("Before Try Statement" + direct[positionInArray].startingLocation);
            System.out.println("Before Try Statement" + direct[positionInArray].destination);
            System.out.println("Before Try Statement" + direct[positionInArray].date);
            System.out.println("Before Try Statement" + direct[positionInArray].blurb);
            System.out.println("Before Try Statement" + direct[positionInArray].duration);
            System.out.println("Before Try Statement" + direct[positionInArray].destination);
                    
        } //end of if tracing
        
        try
        {
                for (int index = 0; index<=positionInArray; index++)
                {

                    /*if (tracing)
                    {
                                System.out.println(positionInArray);
                                System.out.println(index);
                                System.out.println("Inside Try Statement" + direct[positionInArray].startingLocation);
                                //System.out.println("Inside Try Statement" + direct[index].startingLocation);
                                System.out.println("Inside Try Statement" + direct[positionInArray].destination);
                                //System.out.println("Inside Try Statement" + direct[index].destination);
                                System.out.println("Inside Try Statement" + direct[positionInArray].date);
                                //System.out.println("Inside Try Statement" + direct[index].date);
                                System.out.println("Inside Try Statement" + direct[positionInArray].blurb);
                                //System.out.println("Inside Try Statement" + direct[index].blurb);
                                System.out.println("Inside Try Statement" + direct[positionInArray].duration);
                                //System.out.println("Inside Try Statement" + direct[index].duration);
                                System.out.println("Inside Try Statement" + direct[positionInArray].destination);
                                //System.out.println("Inside Try Statement" + direct[index].destination);
                     } //end of tracing
                     */  

                            outfile.println(direct[index].startingLocation);
                                if (tracing) System.out.println(direct[index].startingLocation);
                            outfile.println(direct[index].destination);
                                if (tracing) System.out.println(direct[index].destination);
                            outfile.println(direct[index].date);
                                if (tracing) System.out.println(direct[index].date);
                            outfile.println(direct[index].blurb);
                                if (tracing) System.out.println(direct[index].blurb);
                            outfile.println(direct[index].duration);
                                if (tracing) System.out.println(direct[index].duration);
                            outfile.println(direct[index].directions);
                                if (tracing) System.out.println(direct[index].directions);

                } //end of for loop (WW)
        }// end of try (WW)
        
        catch(Exception e) //if all else fails, print 0.  (WW)
        {
            if (tracing) System.out.println("Catch Statement");
        outfile.println("0");
        } //end of catch (WW)
        
                outfile.close();    
                
                System.out.println("Printed all information");
                
    } //end of write to file method
    
    /**************************************************************************************************************************************
     * Description of Method: Shows a welcome screen
     * Parameters and Return Type: None. 
     * Pre conditions: JButons must exist in class.
     * Post conditions: Would have showed the welcome screen. 
     * ************************************************************************************************************************************
     */  
    
    private void kiaOra() throws IOException
    {
        
        JFrame frame = new JFrame("Welcome!"); 
            frame.setFont(titleFont);
            frame.addWindowListener
            (new WindowAdapter()
              {
                public void windowClosing(WindowEvent e)
                {
                  System.exit(0);
                }
              }
            );        
        
        JPanel panel1 = new JPanel(new BorderLayout());
        
        JLabel welcome = new JLabel("         Welcome to the Program! ");
            welcome.setFont(titleFont);
            welcome.setBackground(red);
        
        JTextArea kO = new JTextArea("   You have the choice of adding a new entry or                  going back to revisit previous entry.\n\n      Have fun using the program and we hope that                       you have a great time");
       
        
        kO.setBackground(darkBlue);
        kO.setForeground(Color.white);
        frame.setBackground(red);
        
        instructions.setFont(mainFont);
        
        kO.setEditable(false);
        kO.setFont(mainFont);
        
        kO.setLineWrap(true);
        kO.setWrapStyleWord(true);        
        
        panel1.add(kO);
        panel1.add(welcome, BorderLayout.NORTH);
        panel1.add(kO, BorderLayout.CENTER);
        panel1.add(instructions, BorderLayout.SOUTH);
        
        frame.setSize(400,400);
        frame.setContentPane(panel1);
        frame.setVisible(true); 
        
        instructions.addMouseListener(this);        
            
    } //end of kiaOra(); 
    
    /**************************************************************************************************************************************
     * Description of Method: Shows a menu screen
     * Parameters and Return Type: None. 
     * Pre conditions: JButons must exist in class.
     * Post conditions: Would have showed the menu screen. 
     * ************************************************************************************************************************************
     */      
    
    private void menu()
    {
        JFrame frame = new JFrame("Menu"); 
            frame.setFont(titleFont);
            //frame.setBackground(red);
            
        frame.addWindowListener
                (new WindowAdapter()
                  {
                    public void windowClosing(WindowEvent e)
                    {
                      System.exit(0);
                    }
                  }
                );        
        
        JPanel panel1 = new JPanel(new BorderLayout());
            panel1.setBackground(red);
        JPanel panel2  = new JPanel(new FlowLayout());
            panel2.setBackground(red);
        JPanel panel3 = new JPanel(new GridLayout(2, 0));
            panel3.setBackground(red);
        JLabel mapIcon = new JLabel(new ImageIcon("nz.jpg"));
            mapIcon.setBackground(red);

        JLabel welcome = new JLabel("             Choose an Option");  
            welcome.setBackground(red);
            welcome.setFont(titleFont);
   

        JTextArea menuDescription = new JTextArea("Click the 'Add New Entry' button to Add a New Entry. Click the 'See Entries.' to see the old entries that you entered previously. You may come back to the menu any time by  pressing the back button.");
            menuDescription.setBackground(darkBlue);
            menuDescription.setForeground(Color.white);
            menuDescription.setFont(mainFont);
        menuDescription.setEditable(false);
         
        menuDescription.setLineWrap(true);
        menuDescription.setWrapStyleWord(true);         

        
        panel1.add(welcome, BorderLayout.NORTH);
        
        panel3.add(menuDescription);
        panel3.add(mapIcon);

        panel2.add(addEntry);
        panel2.add(seeEntry);
        
        panel1.add(panel2, BorderLayout.SOUTH);
        panel1.add(panel3, BorderLayout.CENTER);        
        
        frame.setSize(400,400);
        frame.setContentPane(panel1);
        frame.setVisible(true);        
        
        addEntry.addMouseListener(this);
        seeEntry.addMouseListener(this);        
        
    } //end of menu();
    
    /**************************************************************************************************************************************
     * Description of Method: Shows the instruction screen
     * Parameters and Return Type: None. 
     * Pre conditions: JButons must exist in class. 
     * Post conditions: The program has displayed the instruction screen
     * ************************************************************************************************************************************
     */     
    
    public void instructions()
    {
       JFrame frame = new JFrame("Instructions!"); 
            frame.setBackground(red);
            frame.setFont(titleFont);
            frame.addWindowListener
                    (new WindowAdapter()
                      {
                        public void windowClosing(WindowEvent e)
                        {
                          System.exit(0);
                        }
                      }
                    );       
        
        JPanel panel1 = new JPanel(new BorderLayout());
            panel1.setBackground(red);
        
        JLabel welcome = new JLabel("           How to Use This Program");
            welcome.setFont(titleFont);
        
        JTextArea instruct = new JTextArea("       The program will give you two options: \n\n      1. Add more entries so you can refer back                                    to them \n           2. Look at all your previous entries. \n\n        Caution: Do not make any changes to the                  text file. It may crash the program. ");
            instruct.setEditable(false);
            instruct.setFont(mainFont);
            instruct.setLineWrap(true);
            instruct.setWrapStyleWord(true); 
            instruct.setBackground(darkBlue);
            instruct.setForeground(Color.white); 
        
        JScrollPane sPane = new JScrollPane(instruct);        

        panel1.add(welcome, BorderLayout.NORTH);
        panel1.add(sPane, BorderLayout.CENTER);
        panel1.add(menu, BorderLayout.SOUTH);
        
        menu.addMouseListener(this);
        
        frame.setSize(400,400);
        frame.setContentPane(panel1);
        frame.setVisible(true);  
        
    } //end of instructions method.
    
    /**************************************************************************************************************************************
     * Description of Method: Adds entries into the list of entries
     * Parameters and Return Type: None. 
     * Pre conditions: JButons must exist in class. 
     * Post conditions: The program has added entries the user wanted
     * ************************************************************************************************************************************
     */      
    
    public void addEntry() 
    {
        
        if (tracing) System.out.println(addEntry);
        
         JFrame frame = new JFrame("Add Entry");
            frame.setBackground(red);
            frame.addWindowListener
                    (new WindowAdapter()
                      {
                        public void windowClosing(WindowEvent e)
                        {
                          System.exit(0);
                        }
                      }
                    );         
         JPanel panels = new JPanel(new BorderLayout());
            panels.setBackground(darkBlue);
            panels.setForeground(Color.white);
         JPanel bottomButtons = new JPanel(new GridLayout(2, 2));
            bottomButtons.setBackground(red);
         JPanel westPanel = new JPanel(new GridLayout(6, 0));
            westPanel.setForeground(Color.white);
            westPanel.setBackground(darkBlue);
            westPanel.setForeground(Color.white);
         JPanel centrePanel = new JPanel(new GridLayout(6, 0));
            centrePanel.setBackground(darkBlue);
            centrePanel.setForeground(Color.white);
         
         
        JLabel blurb = new JLabel("Description");
            blurb.setBackground(darkBlue);
            blurb.setForeground(Color.white);
        JLabel start = new JLabel("Start");
            start.setBackground(darkBlue);
            start.setForeground(Color.white);
        JLabel destination = new JLabel("Destination");
            destination.setBackground(darkBlue);
            destination.setForeground(Color.white);
        JLabel date = new JLabel("Date"); 
            date.setBackground(darkBlue); 
            date.setForeground(Color.white);
        JLabel duration = new JLabel("Duration");
            duration.setBackground(darkBlue); 
            duration.setForeground(Color.white); 
        JLabel directions = new JLabel("Directions");            
            directions.setBackground(darkBlue);
            directions.setForeground(Color.white); 
            
            //adding components to bottom button
         bottomButtons.add(goBackMenu);
         bottomButtons.add(reset);
         bottomButtons.add(continueAdd);
         
         //adding buttons to mouseListener
         goBackMenu.addMouseListener(this);
         reset.addMouseListener(this);
         continueAdd.addMouseListener(this);
         
         //add things into westpanel
         westPanel.add(start);
         westPanel.add(destination);
         westPanel.add(date); 
         westPanel.add(blurb);         
         westPanel.add(duration); 
         westPanel.add(directions);
                        
        //File directory = new File ("Macintosh HD/Users/nataliechin/NetBeans Project/AotearoaDirections/src/aotearoadirections/maps/");

        //File [] files = directory.listFiles();   
        
        //while(counter<files.length)
        //{
          // System.out.println("hello");
        //}         
         
         //adding things into the centre panel: 
         centrePanel.add(s);     
         centrePanel.add(di);  
         centrePanel.add(da);
         centrePanel.add(b);           
         centrePanel.add(durationField);         
         centrePanel.add(d);  
         
         //adding things into the panel 
         panels.add(bottomButtons, BorderLayout.SOUTH);
         panels.add(westPanel, BorderLayout.WEST);
         panels.add(centrePanel, BorderLayout.CENTER);         
         
         //making changes to the frame and stuff
         frame.setSize(400,400);
         frame.setContentPane(panels);
         frame.setVisible(true);           
         
    } //end of add entry
    
    /**************************************************************************************************************************************
     * Description of Method: Lets the user look at entries
     * Parameters and Return Type: None.
     * Pre conditions: JButons must exist in class. 
     * Post conditions: The program has displayed entries the user entered in the past
     * ************************************************************************************************************************************
     */      
    
    public void seeEntry()
    {   
        startingSeeEntry.setText("");
        destinationSeeEntry.setText(""); 
        dateSeeEntry.setText("");
        
        if(tracing) System.out.println("see entry");
        
        JFrame frame = new JFrame("See Entries");
            frame.setBackground(red);
            frame.addWindowListener
                    (new WindowAdapter()
                      {
                        public void windowClosing(WindowEvent e)
                        {
                          System.exit(0);
                        }
                      }
                    );        
        
        JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(red);
        JPanel gridWest = new JPanel(new GridLayout(3, 0));
            gridWest.setBackground(darkBlue);
            gridWest.setForeground(Color.white);
        JPanel gridCentre = new JPanel(new GridLayout(3, 0));
            gridCentre.setBackground(darkBlue);
            gridCentre.setForeground(Color.white);
        JPanel southPanel = new JPanel(new GridLayout(0, 3));
            southPanel.setBackground(red);
        
        JLabel northLabel = new JLabel("What Entry Would You Like To See? ");
            northLabel.setBackground(red);
        JLabel westernStartLabel = new JLabel("Starting Location: ");
            westernStartLabel.setBackground(darkBlue);
            westernStartLabel.setForeground(Color.white);
        JLabel westernDestinationLabel = new JLabel("Destination: ");
            westernDestinationLabel.setBackground(darkBlue);
            westernDestinationLabel.setForeground(Color.white);
        JLabel westernDateLabel = new JLabel("Date: ");
            westernDateLabel.setBackground(darkBlue);
            westernDateLabel.setForeground(Color.white);
        
        panel.add(northLabel, BorderLayout.NORTH);
        
        //Add everything into GridWest panel
        
        gridWest.add(westernStartLabel);
        gridWest.add(westernDestinationLabel);
        gridWest.add(westernDateLabel);
        
        //Add the gridWest panel into the panel
        
        panel.add(gridWest, BorderLayout.WEST);
        
        //Add the labels to the gridCentre Panel
        
        gridCentre.add(startSee);
        gridCentre.add(destSee);
        gridCentre.add(dateSee); 
        
        //Add the gridCentre to the panel
        
        panel.add(gridCentre, BorderLayout.CENTER);
        
        continueSeeEntry.addMouseListener(this);
        continueAddEntry.addMouseListener(this);
        continueMenu.addMouseListener(this);
        
        
        //add the components to the south panel
        
        southPanel.add(continueMenu);        
        southPanel.add(continueSeeEntry); 
        southPanel.add(continueAddEntry);  
        
        //adding southPanel to the mainPanel. 
        
        panel.add(southPanel, BorderLayout.SOUTH);
        
        frame.setSize(400,400);
        frame.setContentPane(panel);
        frame.setVisible(true);
        
    } //end of seeEntry method
    
    /**************************************************************************************************************************************
     * Description of Method: Lets the user look at the individual entry that they want to
     * Parameters and Return Type: None.
     * Pre conditions: JButons must exist in the class, the mouseListener must listen to movement, and the variable seeingEntryDisplaying must be valid. 
     * Post conditions: the user will have seen the individual ones. 
     * ************************************************************************************************************************************
     */       
    
    private void seeIndividualEntry()
    {
        leaveMenu.addMouseListener (this);
          
            JFrame frameView = new JFrame("See Individual Entries");
            frameView.setBackground(darkBlue);
            frameView.addWindowListener
                    (new WindowAdapter()
                      {
                        public void windowClosing(WindowEvent e)
                        {
                          System.exit(0);
                        }
                      }
                    );            
            
            JPanel mainView = new JPanel(new BorderLayout());
                mainView.setBackground(darkBlue);
            JPanel flowLayoutViewNorth = new JPanel(new GridLayout(2, 0));
                flowLayoutViewNorth.setBackground(red);
                flowLayoutViewNorth.setForeground(Color.white);
            JPanel flowLayoutViewSouth = new JPanel(new GridLayout(3,0));
                flowLayoutViewSouth.setBackground(red);
                flowLayoutViewSouth.setForeground(Color.white);
                
                if (tracing) System.out.println(direct[seeEntryDisplaying].blurb);
            JLabel blurbDestinationView = new JLabel(direct[seeEntryDisplaying].blurb);
                if (tracing) System.out.println(direct[seeEntryDisplaying].blurb);
                
            JLabel startView = new JLabel(direct[seeEntryDisplaying].startingLocation);
                if (tracing) System.out.println(direct[seeEntryDisplaying].startingLocation);
                
            JLabel destinationView = new JLabel(direct[seeEntryDisplaying].destination);
                if (tracing) System.out.println(direct[seeEntryDisplaying].destination);
                
            JLabel directionsView = new JLabel(direct[seeEntryDisplaying].directions);            
                 JScrollPane directionsViewCentre = new JScrollPane(directionsView);
                    if (tracing) System.out.println(direct[seeEntryDisplaying].directions);
                    
            JLabel durationView = new JLabel(direct[seeEntryDisplaying].duration);
                if (tracing) System.out.println(direct[seeEntryDisplaying].duration);
                
            JLabel dateView = new JLabel(direct[seeEntryDisplaying].date);
                if (tracing) System.out.println(direct[seeEntryDisplaying].date);
                
                directionsView.setBackground(darkBlue);
                
                //setting colors 
                startView.setBackground(red);
                destinationView.setBackground(red);
                blurbDestinationView.setBackground(red);
                durationView.setBackground(red);
                
                //dateView.setBackground();
            
                //add things into north panel: 
            flowLayoutViewNorth.add(startView);
            flowLayoutViewNorth.add(destinationView);
            
            //adding components into south panel
            flowLayoutViewSouth.add(dateView);
            flowLayoutViewSouth.add(durationView);
            flowLayoutViewSouth.add(leaveMenu);
            
            //adding components to mainView. 
            mainView.add(flowLayoutViewNorth, BorderLayout.NORTH);
            mainView.add(blurbDestinationView, BorderLayout.NORTH);
            mainView.add(directionsViewCentre, BorderLayout.CENTER);
            mainView.add(flowLayoutViewSouth, BorderLayout.SOUTH);
            
            //specifying things for frameView
            frameView.setSize(400,400);
            frameView.setContentPane(mainView);
            frameView.setVisible(true);  
    } //end of seeIndividual Entry
    
    /**
     *
     * @param whatClicked
     */
    
    /**************************************************************************************************************************************
     * Description of Method: determines what was clicked on the screen.
     * Parameters and Return Type: None. 
     * Pre conditions: Mouse Listener must be imported, and it must be on class definition
     * Post conditions: The program has determined what the user clicked.
     * ************************************************************************************************************************************
     */      
    
    @Override
    public void mouseClicked(MouseEvent whatClicked)  // use this method to perform actions when the mouse button is pressed AND released
    {
        if(whatClicked.getSource()==instructions) // if testButton component was clicked (note the alternate technique)
        { 
            System.out.println("Instructions");
               instructions();
        } //end of if statement for instructions button         
        
        if(whatClicked.getSource()==menu) // if testButton component was clicked (note the alternate technique)
        {
               menu();
        }   //end of if statement for menu button
        
        if(whatClicked.getSource()==seeEntry) // if testButton component was clicked (note the alternate technique)
        {
               seeEntry();
        }    //end of if statement for seeEntry Button in menu      
        
        if(whatClicked.getSource()==addEntry) // if testButton component was clicked (note the alternate technique)
        {
               addEntry();
        } //end of if statement for addEntry button in menu
        
        if (whatClicked.getSource() == goBackMenu)
        {
            menu();
        } //end of if statement for goBackManu in the addEntry Method.  
        
        if(whatClicked.getSource() == continueAdd)
        {
            boolean dontContinue = false;  
            int p = -1;        

                String tempStarting = "", tempDestination = "", tempDates = "", tempBlurbs = "", tempDuration = "", tempDirections = ""; 

                   if (tracing) System.out.println("Getting user input"); 
                   try
                   {
                   tempStarting = startField.getText().trim();
                   }  //end of try statement
                   catch (Exception e)
                   {
                       tempStarting = ""; 
                   } //end of catch 


                   if (tracing) System.out.println("Getting user input"); 
                   try
                   {
                   tempDestination = destinationField.getText().trim();
                   }  //end of try statement
                   catch (Exception e)
                   {
                       tempDestination = ""; 
                   } //end of catch

                   if (tracing) System.out.println("Getting user input");   
                   try
                   {
                   tempDates = dateField.getText().trim();
                   }  //end of try statement
                   catch (Exception e)
                   {
                       tempDates = ""; 
                   } //end of catch statement

                   if (tracing) System.out.println("Getting user input");  
                   try
                   {
                   tempBlurbs = blurbField.getText().trim();
                   }  //end of try statement
                   catch (Exception e) 
                   {
                    tempBlurbs = "";    
                   } //end of catch statement

                   if (tracing) System.out.println("Getting user input"); 
                   try
                   {
                   tempDuration = durationField.getText().trim();
                   } //end of try statement
                   catch (Exception e)
                   {
                        tempDuration = ""; 
                   } //end of catch statement

                   if (tracing) System.out.println("Getting user input");  
                   try
                   {
                   tempDirections = directionsField.getText().trim();
                   } //end of try statement
                   catch (Exception e)
                   {
                       tempDirections = ""; 
                   } //end of catch statement

                        if (tempStarting.equals ("") || tempStarting == null || tempDestination.equals("") ||tempDestination == null || tempDates.equals("") || tempDates == null || tempBlurbs.equals("") || tempBlurbs == null || tempDuration.equals("") || tempDuration == null || tempDirections.equals("") || tempDirections == null)
                        {
                            JOptionPane.showMessageDialog(null, "Please fill in all the fields. If you wish to leave something blank, please type 'n/a' ", "No input?", JOptionPane.ERROR_MESSAGE);
                        }  //end of if statement
                        else
                        {
                            
                            System.out.println(positionInArray);
                            //positionInArray++; 
                            
                            //In the very beginnning, p will always be 0. This means that positionInArray does not need to be increased. when p goes through the first move, p will equal 1 already. 
                            if (p>=0 || positionInArray>=0) 
                            {
                                positionInArray++;
                            }                             
                            
                            p++; 
                              
                                
                            System.out.println(positionInArray);    
                            direct[positionInArray] = new Directions(); 
                            
                                direct[positionInArray].startingLocation = tempStarting; 
                                    if (tracing) System.out.println("" + direct[positionInArray].startingLocation);
                                direct[positionInArray].destination = tempDestination; 
                                    if (tracing) System.out.println(direct[positionInArray].destination);
                                direct[positionInArray].date = tempDates;  
                                    if (tracing) System.out.println(direct[positionInArray].date);
                                direct[positionInArray].blurb = tempBlurbs; 
                                    if (tracing) System.out.println(direct[positionInArray].blurb);
                                direct[positionInArray].duration = tempDuration;   
                                    if (tracing) System.out.println(direct[positionInArray].duration);
                                direct[positionInArray].directions = tempDirections;   
                                    if (tracing) System.out.println(direct[positionInArray].directions);
                                    
                                //Try catch statement here for calling the write to file method becuase it needs a throw IOException on method header and putting an exception on the method header of the MouseListener would not work. 
                                try 
                                {
                                    writeToFile();
                                } //end of try
                                catch (IOException ex) 
                                {
                                    Logger.getLogger(AotearoaDirections.class.getName()).log(Level.SEVERE, null, ex);
                                } //end of catch 
                                  JOptionPane.showMessageDialog(null, "All your input was saved.", "Input", JOptionPane.ERROR_MESSAGE);
                                  menu();
                        } //end of else statement
            
        } //end of continuingAdd statement for adding entry method
        
        if (whatClicked.getSource() == reset)
        {
            //if the reset button is clicked, clear all the fields...
            startField.setText("");
            destinationField.setText("");
            dateField.setText("");
            blurbField.setText("");
            durationField.setText("");
            directionsField.setText("");
        } //end of if statement
        
        if (whatClicked.getSource()==continueSeeEntry)
        {
            boolean entry = false; 
            
            if (tracing) System.out.println("Before entering try statement. ");
            
            String tempStart; 
            String tempDest; 
            String tempDate; 
            int i = -1;
            
            /**For all try - catch statements, they are as follows: 
             * 
             * try
             * {
             * Tracing of inside _____. 
             * Read in the information. 
             * Tracing of of temp variable
             * Tracing of is in the textfield. 
             * } 
             * catch (Exception e)
             * {
             * make temp variable equal "" so the program will go back and display an error. 
             * }
             * 
             */
                    
            try
            {
                if (tracing) System.out.println("Inside try statement for tempStart. ");
                tempStart = startingSeeEntry.getText().trim();
                if (tracing) System.out.println(tempStart);
                if (tracing) System.out.println(startingSeeEntry.getText().trim());
            }
            catch (Exception e)
            {
                tempStart = ""; 
                if (tracing) System.out.println(tempStart + "catch statement");
            } //end of catch 
            
            try
            {
                if (tracing) System.out.println("Inside try statement for tempDest");
                tempDest = destinationSeeEntry.getText().trim();
                if (tracing) System.out.println(tempDest);
                if (tracing) System.out.println(destinationSeeEntry.getText().trim());                
            } //end of try 
            catch (Exception e)
            {
                tempDest = ""; 
                if (tracing) System.out.println(tempDest + "catch statement");
            } //end of catch
            
            try
            {
                if (tracing) System.out.println("Inside try statement for tempDate. ");
                tempDate = dateSeeEntry.getText().trim(); 
                if (tracing) System.out.println(tempDate);
                if (tracing) System.out.println(dateSeeEntry.getText().trim());                
            } //end of try
            catch (Exception e)
            {
                tempDate = ""; 
                if (tracing) System.out.println(tempDate + "catch statement");
            }
            
            if (tracing) System.out.println("Before For Loop: " + "Temp Date -" +tempDate+ "Temp Start - " +tempStart+ "TempDest" +tempDest);           
            
            int j = 0; 
            
            //If the user didn't enter anything: 
            if (tempStart.equals("") || tempStart == null || tempDest.equals("")  || tempDest == null|| tempDest.equals("Date") || tempDest == null)
            {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields. ", "No input?", JOptionPane.ERROR_MESSAGE);                
            } //end of if statement
            
            //Otherwise, if they did enter something, the program will go through this part of the program. 
            else
            {
                if (tracing) System.out.println(positionInArray);
                if (tracing) System.out.println("Starting Location before Searching: " + direct[positionInArray].startingLocation);
                if (tracing) System.out.println("Destination before Searching: " + direct[positionInArray].destination);
                if (tracing) System.out.println( "Date before Searching: " +direct[positionInArray].date);
                
                    for (seeEntryDisplay = 0; seeEntryDisplay<=positionInArray; seeEntryDisplay++)
                    {
                            if (tracing) System.out.println("Inside the array: " +"|"+direct[seeEntryDisplay].startingLocation+"|" + " Value of tempStart: " +tempStart);
                            if (tracing) System.out.println("inside of the array: " +"|"+direct[seeEntryDisplay].destination+"|"+ " Value of tempDest: " +tempDest);
                            if (tracing) System.out.println("inside of the array: " +"|"+direct[seeEntryDisplay].date+"|"+ " Value of tempDate: " +tempDate);
                                                    
                        if (tracing) System.out.println("Inside the for loop");
                        if (tracing) System.out.println("BOLJDFLSDKFJSLDKFJLCVKNFJS" + (((direct[seeEntryDisplay].startingLocation).equals(tempStart)) && (direct[seeEntryDisplay].destination).equals(tempDest) && (direct [seeEntryDisplay].date).equals(tempDate)));
                        
                        //If there are things inside the textfield, then make seeEntryDisplaying, a global variable equal the position and so the seeIndividualEntries method can access it.  (aw) 
                        if (((direct[seeEntryDisplay].startingLocation).equals(tempStart)) && (direct[seeEntryDisplay].destination).equals(tempDest) && (direct [seeEntryDisplay].date).equals(tempDate))
                        { 
                            if (tracing) System.out.println("Inside the array: " +"|"+direct[seeEntryDisplay].startingLocation+"|" + "Value of tempStart: " +tempStart);
                            if (tracing) System.out.println("inside of the array: " +"|"+direct[seeEntryDisplay].destination+"|"+ "Value of tempDest: " +tempDest);
                            if (tracing) System.out.println("inside of the array: " +"|"+direct[seeEntryDisplay].date+"|"+ "Value of tempDate: " +tempDate);
                            seeEntryDisplaying = seeEntryDisplay;
                            
                            seeIndividualEntry();  
                        } //end of tempStart
                        //If there's nothing in the textField (aw) 
                        else
                        {
                            JOptionPane.showMessageDialog(null, "We couldn't find anything matching those search entries...\n Please enter another input or go back to the menu.", "We're sorry!", JOptionPane.ERROR_MESSAGE);                 
                        } //end of else statement
                    } //end of for loop.   
            } //end of else statement
            
                        
        } //end of an if statement
        
        if (whatClicked.getSource()==continueAddEntry)
        {
            JOptionPane.showMessageDialog(null, "We'll bring you to the Add Entry Section now", "Add Entries!", JOptionPane.INFORMATION_MESSAGE);                             
            addEntry();
        } //end of if statement
        
        if (whatClicked.getSource() == continueMenu)
        {
            menu();
        } //end of if statement
        
        if (whatClicked.getSource() == leaveMenu)
        {
            menu();
        } //end of leaveMenu if statement
        
    } //end of whatClicked Method
    
    /**************************************************************************************************************************************
     * Description of Method: Determines what was pressed on the screen (mouse was pressed but not released)
     * Parameters and Return Type: None. 
     * Pre conditions: Mouse Listener must be imported, and it must be on class definition
     * Post conditions: The program has determined what the user pressed on.
     * ************************************************************************************************************************************
     */     

    /**
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) // use this method to perform actions when the mouse button is pressed
    {
    }
    
    /**************************************************************************************************************************************
     * Description of Method: Determines what was released on the screen
     * Parameters and Return Type: None. 
     * Pre conditions: Mouse Listener must be imported, and it must be on class definition
     * Post conditions: The program has determined what the user released their mouse on.
     * ************************************************************************************************************************************
     */     

    /**
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) // use this method to perform actions when the mouse button is released
    {
        
    }
    
    /**************************************************************************************************************************************
     * Description of Method: Determine the x or y coordinates the user's movement from mouse entered.
     * Parameters and Return Type: None. 
     * Pre conditions: Mouse Listener must be imported, and it must be on class definition
     * Post conditions: The program now contains where the mouse entered on a component
     * ************************************************************************************************************************************
     */     

    /**
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e)  // use this method to perform actions when the mouse enters a component
    {
    }
    
    /**************************************************************************************************************************************
     * Description of Method: Determine the x or y coordinates the user's movement from mouse exited.
     * Parameters and Return Type: None. 
     * Pre conditions: Mouse Listener must be imported, and it must be on class definition
     * Post conditions: The program now contains where the mouse exited on a component
     * ************************************************************************************************************************************
     */      

    /**
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e)  // use this method to perform actions when the mouse exits a component
    {
    }
    
    /**************************************************************************************************************************************
     * Description of Method: Determines where the mouse has moved from one place to another.
     * Parameters and Return Type: None. 
     * Pre conditions: Mouse Listener must be imported, and it must be on class definition
     * Post conditions: The program now contains where the mouse moved (from where to where)
     * ************************************************************************************************************************************
     */      
    
    /**
     *
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e)  //This method is called when a mouse is moved, without a button being pressed, over the component to which we are listening
    {
        System.out.println("X: "+e.getX()+" Y:"+e.getY());
    }

    /**************************************************************************************************************************************
     * Description of Method: Determines, when the buttons are held down, where it is "dragged"
     * Parameters and Return Type: None. 
     * Pre conditions: Mouse Listener must be imported, and it must be on class definition
     * Post conditions: The program now contains where the mouse was dragged. 
     * ************************************************************************************************************************************
     */      
    
    /**
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e)  // This method is called when a mouse is moved, with a button held down,over the component to which we are listening
    {                                                                  
    }
    
    /**************************************************************************************************************************************
     * Description of Method: Part of KeyListener determines what key was pressed (but not released)
     * Parameters and Return Type: None. 
     * Pre conditions: Key Listener must be imported, and it must be on class definition
     * Post conditions: The program now knows what key was pressed.
     * ************************************************************************************************************************************
     */      

    /**
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e)  // use this method to perform actions when a key is pressed on the keyboard
    {
    }

    /**************************************************************************************************************************************
     * Description of Method: Part of KeyListener determines what key was released (but not pressed)
     * Parameters and Return Type: None. 
     * Pre conditions: Key Listener must be imported, and it must be on class definition
     * Post conditions: The program now knows what key was released
     * ************************************************************************************************************************************
     */    
    
    /**
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e)  // use this method to perform actions when a key is released on the keyboard
    {
    }

    /**************************************************************************************************************************************
     * Description of Method: Part of KeyListener determines what key was typed (pressed and released)
     * Parameters and Return Type: None. 
     * Pre conditions: Key Listener must be imported, and it must be on class definition
     * Post conditions: The program now knows what key was typed
     * ************************************************************************************************************************************
     */    
    
    /**
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e)  // use this method to perform actions when a key is 
    // pressed AND released on the keyboard
    {
        
    }   
    
    /**************************************************************************************************************************************
     * Description of Method: Part of ActionListener determines what key was pressed (but not released)
     * Parameters and Return Type: None. 
     * Pre conditions: Action Listener must be imported, and it must be on class definition
     * Post conditions: The program now what component was clicked on
     * ************************************************************************************************************************************
     */    
    
    /**
     *
     * @param whatClicked
     */
    @Override
    public void actionPerformed(ActionEvent whatClicked)// use this method to perform actions when 
    {
      
        
    }     //end of method

} //end of public class. 


/**
 *
 * @author nataliechin
 */

/**PROBLEMS AND SOLUTIONS
 * 
 * Problem 1: When clicking the JButton, but the program wouldn't do anything………(while programming!)
 * Solution: Component was added to the MouseListener class, but the code for it to do stuff was put into the Action Listener method. 
 * What it means for the program: Nothing. It was just a programming error…
 * 
 * Problem 2: While running the program, it bypasses both the outside and inside for loop! By using tracing statements, it shows that it isn't going into the For Loop, and therefore isn't reading anything from any file!
 * Solution: PositionInArray was equal to 0, so it was never going to run in the first place. 
 * What It Means for the Program: Nothing, it was a programming error. 
 * 
 * Problem 3: When clicking the reset form button when adding a new entry, it doesn't work that well. Actually, it doesn't work at all. It clears everything but the date, and the label goes missing. 
 * Solution: When I set the text to "" in the dateField, I set the text in DATE and instead of DATEFIELD. 
 * What It Means for the Program: Absolutely nothing. 
 * 
 * Problem 4: While programming the part for where users enter something invalid (in the mouseClicked method for the see Entry), the optionPane wouldn't show up. 
 * Solution: Had to import the windowConstant (not just the JOptionPane) according to the Java APIs. 
 * What it means for the program: Nothing. 
 * 
 * Problem 5: Had a massive problem with this part of the program: 
 * while (tempStarting.equals("") || (tempStarting.equals(null)))
                {
                    if (tracing) System.out.println("Inside while loop. ");

                         if (tracing) System.out.println("Inside the try statement for starting location 1");
                         
                         tempStarting = JOptionPane.showInputDialog("Please enter the Starting Location: ");
                         
                                if (tempStarting == null) tempStarting = ""; 
                         
                         if (tracing) System.out.println("Value of tempStarting:  " +tempStarting);
                         
                         
                        
                    if ((tempStarting == null || (tempStarting.equals("")))) //if the loop has played at least once or more than once.
                    { 
                            JOptionPane.showMessageDialog(null, "We didn't understand your input. Please re-enter", "Invalid Input", JOptionPane.INFORMATION_MESSAGE); 

                    }// end of if statement
                    else //if tempStarting contains information, it will enter this else statement and then, when it gets to the end of the loop, it won't restart because of the while loop. 
                    {
                        direct[positionInArray].startingLocation = tempStarting;
                    }  //end of else statement
                    if (tracing) System.out.println(tempStarting);
                    if (tracing) System.out.println(direct[positionInArray].startingLocation);
                } //end of while loop
                * Because after it ran, nothing worked. if the cancel button was pressed, tempStarting would always be null. 
 * Solution: When testing whether something is equal to null - even if it's a string, ".equals" doesn't work. It must say ==. 
 * What it means for the program: Nothing. 
 * 
 * Problem 6: The variable positionInArray wasn't changing at the right times causing the program to entirely skip a section of code. 
 * Solution: I was increasing positionInArray at a time that I didn't need to - the first time through the program. 
 * What it means for the program: Nothing. 
 * 
 * Problem 7: 
 * Solution: 
 * 
 * Problem 8: 
 * Solution: 
 * 
 * Problem 9: 
 * Solution: 
 * 
 * Problem 10: 
 * Solution: 
 * 
 */
