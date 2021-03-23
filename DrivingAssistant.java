import java.util.Scanner;

public class DrivingAssistant {
    public static void main(String[] args) {
        System.out.println("Welcome, I am your driving assistance. Type \"power off\" to turn me off. I can also have a discussion about driving ethics with you if you type \"talk\". Lastly, if you need to call your emergency contact, simply type \"not okay\". How may I help?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.toLowerCase();
        input = input.replaceAll("[?!.]", "");

    
        while(!input.equals("power off")){
            int frontDistance = DrivingAssistant.frontRadar();
            int rearDistance = DrivingAssistant.rearRadar();

            if(input.indexOf("right") >= 0 && input.indexOf("turn") >= 0){
                System.out.println(rightTurn(frontDistance));
            }

            else if(input.indexOf("left") >= 0 && input.indexOf("turn") >= 0){
                System.out.println(leftTurn(frontDistance));
            }

            else if(input.indexOf("intersection") >= 0 || input.indexOf("traffic light") >= 0 || input.indexOf("light") >= 0 || input.indexOf("cross") >= 0){
                System.out.println(intersection(frontDistance));
            }

            else if(input.indexOf("back") >= 0 && input.indexOf("up") >= 0 || input.indexOf("enough space") >= 0 || input.indexOf("space") >= 0){
                System.out.println(backUp(rearDistance));
            }

            else if (input.indexOf("hello") >= 0){
                System.out.println("Hi, how may I help you?");
            }

           
            else if(DrivingAssistant.findKeyword(input, "hi", 0) != -1){
                System.out.println("Hi, how may I help you?");

            }
                
            else if (input.indexOf("how are you")>=0 || input.indexOf("how do you do") >= 0){
                System.out.println("I am doing well! Where should we go?");
            }

            else if (input.indexOf("what do you do")>=0){
                System.out.println("I am a driving assistant that helps you make quick decisions on the road. You can ask me questions about making turns, backing up, or crossing the intersection.");
            }

            else if (input.indexOf("i do not need help")>=0){
                System.out.println("If you do not need help, go ahead and type \"power off\" to turn off.");
            }

            else if (input.indexOf("name")>=0){
                System.out.println("My name is DJ, your driving assistant. You can ask me questions about making turns, backing up, or crossing the intersection.");
            }

            else if (input.indexOf("goodbye")>=0){
                System.out.println("Thanks for talking to me!");
            }

            else if (input.equals("okay")){
                System.out.println("Alright!");
            }

            else if (input.indexOf("not okay") >= 0){
                System.out.println("I will be calling your emergency contact.");
            }

            else if (DrivingAssistant.findKeyword(input, "who",0) != -1){
                System.out.println("My name is DJ, your driving assistant. You can ask me questions about making turns, backing up, or crossing the intersection.");
            }

            else if (DrivingAssistant.findKeyword(input,"talk",0) != -1){
                System.out.println("Since I am just an assistant, the driver has complete control of the car, eliminating ethical concerns. You can always tell me to power off, but ultimately I am here for advice and help!");
            }

            else if (input.indexOf("healthcare") >= 0){
                System.out.println("AI was able to partner with medical institutes to discover a new disease through numerous amounts of research of new genes.");
            }

            else if (input.indexOf("transportation") >= 0 || input.indexOf("technology") >= 0 || input.indexOf("future") >= 0){
                System.out.println("Self driving cars are one of the biggest arising technologies currently, that will be able to reduce traffic-related deaths and injuries significantly."); 
            }

            else if(input.indexOf("education") >= 0 || input.indexOf("literature") >= 0 || input.indexOf("history") >= 0){
                System.out.println("AI has been developing robot assistants to help out teachers during the school day and answer questions the students might have.");
            }

            else if(input.indexOf("environment") >= 0){
                System.out.println(environment(frontDistance));
            }

            else if(input.indexOf("discrimination") >= 0 || DrivingAssistant.findKeyword(input, "flaw",0) != -1){
                System.out.println("Since a lot of AI systems run on large amounts of data, some with which are flawed, another AI tool has been used to detect things like discrimination in respect to one’s specific attributes (like race)");
            }

            else{
                System.out.println("I do not understand, please repeat: ");
                
            }
           

            //continuously asking commands
            input = scanner.nextLine();
            input = input.toLowerCase();
            input = input.replaceAll("[?!.]", "");
        }
        System.out.println("Powering Off...");

    }

    public static int frontRadar() {
        int distance1 = (int) (Math.random() * 10 + 1);
        return distance1;
     }
 
     public static int rearRadar() {
         int distance = (int) (Math.random() * 10 + 1);
         return distance;
      }  
     public static int frontCam(){
         int responseNum = (int) (Math.random() * 3 + 1);
         return responseNum;
     }

     public static int rearCam(){
        int responseNum = (int) (Math.random() * 3 + 1);
        return responseNum;
    }

     public static String rightTurn(int RTD){
        int RRN = frontCam();
        if(RTD >= 8){
            return "Please get closer, you have " + RTD + " meters left.";
        }
        else if(RTD >= 5){
            return "Please get to the right most lane, you have " + RTD + " meters left.";
        }
       else{
            if(RRN == 1){
                return "You may go but proceed with caution.";
            }
            else if(RRN == 2){
                return "Do not go, there is a pedestrian crossing.";
            }
            else{
                return "Do not go, the light is yellow.";
            }
        }
     }

     public static String leftTurn(int LTD){
        int LRN = frontCam();
        if(LTD >= 8){
            return "Please get closer, you have " + LTD + " meters left.";
        }
        else if(LTD >= 5){
            return "Please get to the left most lane, you have " + LTD + " meters left.";
        }
       else{
            if(LRN == 1){
                return "You may go but proceed with caution.";
            }
            else if(LRN == 2){
                return "Do not go, there is a pedestrian crossing.";
            }
            else{
                return "Do not go, the light is yellow.";
            }
        }
     }
   
     public static String intersection(int ID){
        int IRN = frontCam();
        if(ID >= 5){
            return "Please get closer, you have " + ID + " meters left.";
        }
       else{
            if(IRN == 1){
                return "You may go but proceed with caution.";
            }
            else if(IRN == 2){
                return "Do not go, there is a pedestrian crossing.";
            }
            else{
                return "Do not go, the light is yellow.";
            }
        }
     }

     public static String backUp(int BUD){
        int BRN = rearCam();
        if(BUD >= 5){
            return "You may continue to back up, there is enough space. Please say \"okay\" once you are done. Otherwise, say \"not okay\"";
        }
       else{
            if(BRN == 1){
                return "Hold, there is a car passing by.";
            }
            else if(BRN == 2){
                return "Hold, there is a pedestrian behind you.";
            }
            else{
                return "Hold, there is a biker passing by.";
            }
        }
     }

    /*  UNDER CONSTRUCTION  
    public static void followUp(){
         System.out.println("Was your action successful?");
         try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
         
            System.out.println("bbb");
         Scanner scanner = new Scanner(System.in); 
         String input = scanner.nextLine();
         input = input.toLowerCase();
         input = input.replaceAll("[?!.]", "");
         if(input.equals(null)){
             System.out.println("Are you still there?");
         }
         else{
             System.out.println("good");
             return;
         }
         //System.out.println("Are you still there?");
         try
         {
             Thread.sleep(1000);
         }
         catch(InterruptedException ex)
         {
             Thread.currentThread().interrupt();
         }         input = scanner.nextLine();
         input = input.toLowerCase();
         input = input.replaceAll("[?!.]", ""); 
         if(input.equals(null)){
            System.out.println("I'm calling 911");
        }
        else{
            System.out.println("good");
            return;
        }

     }
     */

     public static String environment(int ansChoice){
        if(ansChoice >= 6){
            return "AI has been used to help protect oceans from illegal fishing and overfishing.";
        }
        else{
            return "It is able to forecast the supply and demand of power and reduce fossil fuel emissions";
        }
     }

     public static int findKeyword(String statement, String goal, int startPos){ 
        String phrase = statement.trim();
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        while (psn >= 0){ 
            String before = " ", after = " "; 
            if (psn > 0){ 
                before = phrase.substring (psn - 1, psn).toLowerCase(); 
            }
            if (psn + goal.length() < phrase.length()){ 
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0) && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))){
             return psn;
            } 
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
        } 
            return -1;

        }
}