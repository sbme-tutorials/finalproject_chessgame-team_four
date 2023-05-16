
import java.util.Scanner ;
import java.time.LocalTime;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class Timer {
    class whiteTimer {

        // return the current minutes from the numper of impression negative second when we add it to 60
        static int currentMin(long firsts, long beginTimeinMilliSec, long finishTimeinMilliSec,int firstM  ) {
            long spentTimeSec=(finishTimeinMilliSec-beginTimeinMilliSec)/1000;
            long currentTimeS=firsts-spentTimeSec;
            int SpentMin =0 ;
            while(currentTimeS<0) {
                currentTimeS=currentTimeS+60;
                SpentMin = SpentMin+1;
            }
            int currentTimeM = firstM - SpentMin ;
            return currentTimeM;
        }
        // return the current second from first minuse spent
        static long currentSec(long firsts,long beginTimeinMilliSec,long finishTimeinMilliSec) {

            long spentTimeSec=(finishTimeinMilliSec-beginTimeinMilliSec)/1000;
            long currentTimeS=firsts-spentTimeSec;

            while(currentTimeS<0) {
                currentTimeS=currentTimeS+60;
            }
            return currentTimeS ;
        }




        static void displayTime(long firstTimeSec,long beginTimeinMilliSec ,int firstTimeMin,boolean pieceis_white , boolean y) {
            // initiate value to compare
            long finishTimeinMilliSec=0 ;
            //calculate time every second when the other player move and stop it when you move
            if (pieceis_white == false && y == true) {
                finishTimeinMilliSec = System.currentTimeMillis();
                long currentSec = whiteTimer.currentSec(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec);
                long currentMin = whiteTimer.currentMin(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec, firstTimeMin);
                System.out.println(currentSec + " " + currentMin);
                while (true) {
                    finishTimeinMilliSec = System.currentTimeMillis();
                    beginTimeinMilliSec=0;
                    currentSec = whiteTimer.currentSec(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec);
                    currentMin = whiteTimer.currentMin(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec, firstTimeMin);
                    if (currentMin<0){currentMin=0;}
                    if(currentSec==0){ System.out.println(currentSec + " " + currentMin);break;}
                    System.out.println(currentSec + " " + currentMin);
                    if(pieceis_white ==true && y == true) {break;}  }}
            //fix time on current time when you move & stop that when the other player move
            if(pieceis_white ==true && y == true){
                finishTimeinMilliSec = System.currentTimeMillis();
                beginTimeinMilliSec=0;
                long currentSec = whiteTimer.currentSec(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec);
                long currentMin = whiteTimer.currentMin(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec, firstTimeMin);
                while (true){
                    if (currentMin<0){currentMin=0;}
                    if(currentSec==0){ System.out.println(currentSec + " " + currentMin);
                        System.out.println("game over");break;}
                    System.out.println(currentSec + " " + currentMin);
                    if(pieceis_white ==false && y == true) {break;}

                }
            }
            // calculate the change in time at the beginning when no one move
            // considering that white is the one who will start
            while (true) {finishTimeinMilliSec = System.currentTimeMillis();
                long currentSec = whiteTimer.currentSec(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec);
                long currentMin = whiteTimer.currentMin(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec, firstTimeMin);
                System.out.println(currentSec + " " + currentMin);
                if (currentMin<0){currentMin=0;}
                if(currentSec==0 && currentMin==0){ System.out.println(currentSec + " " + currentMin);
                    System.out.println("game over");break;}
                if(y == true) {break;}
            }}}


    class blackTimer {

        // return the current minutes from the numper of impression negative second when we add it to 60
        static int currentMin(long firsts, long beginTimeinMilliSec, long finishTimeinMilliSec,int firstM  ) {
            long spentTimeSec=(finishTimeinMilliSec-beginTimeinMilliSec)/1000;
            long currentTimeS=firsts-spentTimeSec;
            int SpentMin =0 ;
            while(currentTimeS<0) {
                currentTimeS=currentTimeS+60;
                SpentMin = SpentMin+1;
            }
            int currentTimeM = firstM - SpentMin ;
            return currentTimeM;
        }
        // return the current second from first minuse spent
        static long currentSec(long firsts,long beginTimeinMilliSec,long finishTimeinMilliSec) {

            long spentTimeSec=(finishTimeinMilliSec-beginTimeinMilliSec)/1000;
            long currentTimeS=firsts-spentTimeSec;

            while(currentTimeS<0) {
                currentTimeS=currentTimeS+60;
            }
            return currentTimeS ;
        }




       /*  boolean pieceis_white=Pieces.Piece.is_white;
         boolean y = Board.Input.Y ;*/

        static void displayTime(long firstTimeSec,long beginTimeinMilliSec ,int firstTimeMin,boolean pieceis_white , boolean y) {
            // initiate value to compare
            long finishTimeinMilliSec=0 ;
            //calculate time every second when the other player move and stop it when you move
            if (pieceis_white == true && y == true) {
                finishTimeinMilliSec = System.currentTimeMillis();
                long currentSec =  blackTimer.currentSec(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec);
                long currentMin = blackTimer.currentMin(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec, firstTimeMin);
                System.out.println(currentSec + " " + currentMin);
                while (true) {
                    finishTimeinMilliSec = System.currentTimeMillis();
                    beginTimeinMilliSec=0;
                    currentSec = blackTimer.currentSec(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec);
                    currentMin = blackTimer.currentMin(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec, firstTimeMin);
                    if (currentMin<0){currentMin=0;}
                    if(currentSec==0){ System.out.println(currentSec + " " + currentMin);break;}
                    System.out.println(currentSec + " " + currentMin);
                    if(pieceis_white ==false && y == true) {break;}  }}
            //fix time on current time when you move & stop that when the other player move
            if(pieceis_white ==false && y == true){
                finishTimeinMilliSec = System.currentTimeMillis();
                beginTimeinMilliSec=0;
                long currentSec = blackTimer.currentSec(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec);
                long currentMin = blackTimer.currentMin(firstTimeSec, beginTimeinMilliSec, finishTimeinMilliSec, firstTimeMin);
                while (true){
                    if (currentMin<0){currentMin=0;}
                    if(currentSec==0){ System.out.println(currentSec + " " + currentMin);
                        System.out.println("game over");break;}
                    System.out.println(currentSec + " " + currentMin);
                    if(pieceis_white ==true && y == true) {break;}

                }
            }
            // calculate the change in time at the beginning when no one move
            // considering that white is the one who will start
            {while (true) {
                long currentSec = firstTimeSec;
                long currentMin = firstTimeMin;
                System.out.println(currentSec + " " + currentMin);
                if( y == true) {break;}
            }}}}}