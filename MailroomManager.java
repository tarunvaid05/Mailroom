/*
Tarun Vaidhyanathan
115510562
R02
 */

import java.util.Scanner;
/**
 * This class represents a Mailroom Manager that manages incoming and outgoing mail
 * There is a menu for all operations
 */
public class MailroomManager {
    /**
     * Main method to run the Mailroom Manager program.
     */
    public static void main(String[] args) {
        PackageStack stack1 = new PackageStack();
        PackageStack stack2 = new PackageStack();
        PackageStack stack3 = new PackageStack();
        PackageStack stack4 = new PackageStack();
        PackageStack stack5 = new PackageStack();
        PackageStack stack6 = new PackageStack();
        int arrivalDate = 0;
        
        System.out.println("Welcome to the Irving Mailroom Manager. You can try to make it better, but the odds are stacked against you. It is day 0.");
        System.out.println("Menu:");
        System.out.println("\tD) Deliver a package");
        System.out.println("\tG) Get someone's package");
        System.out.println("\tT) Make it tomorrow");
        System.out.println("\tP) Print the stacks");
        System.out.println("\tM) Move a package from one stack to another");
        System.out.println("\tF) Find packages in the wrong stack and move to floor");
        System.out.println("\tL) List all packages awaiting a user");
        System.out.println("\tE) Empty the floor.");
        System.out.println("\tQ) Quit");

        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("Please select an option: ");
            String choice = input.nextLine().trim().toUpperCase();
            switch (choice){
                case "D":
                    System.out.print("Please enter the recipient name: ");
                    String recipient = input.nextLine().trim();
                    System.out.print("Please enter the weight (lbs): ");
                    double weight = input.nextDouble();
                    input.nextLine();
                    Package p = new Package(recipient, arrivalDate, weight);
                    String temp = recipient.toUpperCase();

                    if(temp.charAt(0) == 'A' || temp.charAt(0) == 'B' || temp.charAt(0) == 'C' || temp.charAt(0) == 'D' ||
                            temp.charAt(0) == 'E' || temp.charAt(0) == 'F' || temp.charAt(0) == 'G'){
                        stack1.packageStack.push(p);
                    }
                    if(temp.charAt(0) == 'H' || temp.charAt(0) == 'I' || temp.charAt(0) == 'J'){
                        stack2.packageStack.push(p);
                    }
                    if(temp.charAt(0) == 'K' || temp.charAt(0) == 'L' || temp.charAt(0) == 'M'){
                        stack3.packageStack.push(p);
                    }
                    if(temp.charAt(0) == 'N' || temp.charAt(0) == 'O' || temp.charAt(0) == 'P' ||
                            temp.charAt(0) == 'Q' || temp.charAt(0) == 'R'){
                        stack4.packageStack.push(p);
                    }
                    if(temp.charAt(0) == 'S' || temp.charAt(0) == 'T' || temp.charAt(0) == 'U' || temp.charAt(0) == 'V' ||
                            temp.charAt(0) == 'W' || temp.charAt(0) == 'X' || temp.charAt(0) == 'Y' || temp.charAt(0) == 'Z'){
                        stack5.packageStack.push(p);
                    }
                    System.out.println("A " + Math.round(p.getWeight()) +" lb package is awaiting pickup by " + p.getRecipient());
                    break;
                case "G":
                    try{
                        System.out.print("Please enter the recipient name: ");
                        String name1 = input.nextLine();
                        String temp2 = name1.toUpperCase();
                        String giveString = "";
                        int count2 = 0;
                        if(temp2.charAt(0) == 'A' || temp2.charAt(0) == 'B' || temp2.charAt(0) == 'C' || temp2.charAt(0) == 'D' ||
                                temp2.charAt(0) == 'E' || temp2.charAt(0) == 'F' || temp2.charAt(0) == 'G'){
                            for(int i = stack1.packageStack.size() - 1; i >= 0; i--){
                                if(!(stack1.packageStack.get(i).getRecipient().equals(name1))){
                                    Package temp3 = stack1.pop();
                                    stack6.push(temp3);
                                    count2++;
                                }
                            }
                            stack1.pop();
                            for(int i = stack1.packageStack.size() - 1; i >= 0 ; i--){
                                Package temp4 = stack6.pop();
                                stack1.push(temp4);
                            }
                            for(int i = 0; i < stack1.packageStack.size(); i++){
                                if(stack1.packageStack.get(i).getRecipient().equals(name1)){
                                    giveString = "Give " + name1 + " " + Math.round(stack1.packageStack.get(i).getWeight()) + " lb package delivered on day " + stack1.packageStack.get(i).getArrivalDate() + "\n";                            }
                            }
                            if((count2-1) > 1){
                                System.out.println("Move " + (count2-1) + " packages from Stack 1 to floor");
                            }
                            else if((count2-1) == 1){
                                System.out.println("Move " + (count2-1) + " package from Stack 1 to floor");
                            }
                        }
                        if(temp2.charAt(0) == 'H' || temp2.charAt(0) == 'I' || temp2.charAt(0) == 'J'){
                            for(int i = stack2.packageStack.size() - 1; i >= 0; i--){
                                if(!(stack2.packageStack.get(i).getRecipient().equals(name1))){
                                    Package temp3 = stack2.pop();
                                    stack6.push(temp3);
                                    count2++;
                                }
                            }
                            stack2.pop();
                            for(int i = stack6.packageStack.size() - 1; i >= 0 ; i--){
                                Package temp4 = stack6.pop();
                                stack2.push(temp4);
                            }
                            for(int i = 0; i < stack2.packageStack.size(); i++){
                                if(stack2.packageStack.get(i).getRecipient().equals(name1)){
                                    giveString = "Give " + name1 + " " + Math.round(stack2.packageStack.get(i).getWeight()) + " lb package delivered on day " + stack2.packageStack.get(i).getArrivalDate() + "\n";
                                }
                            }
                            if((count2-1) > 1){
                                System.out.println("Move " + (count2-1) + " packages from Stack 2 to floor");
                            }
                            else if((count2-1) == 1){
                                System.out.println("Move " + (count2-1) + " package from Stack 2 to floor");
                            }
                        }
                        if(temp2.charAt(0) == 'K' || temp2.charAt(0) == 'L' || temp2.charAt(0) == 'M'){
                            for(int i = stack3.packageStack.size() - 1; i >= 0; i--){
                                if(!(stack3.packageStack.get(i).getRecipient().equals(name1))){
                                    Package temp3 = stack3.pop();
                                    stack6.push(temp3);
                                    count2++;
                                }
                            }
                            stack3.pop();
                            for(int i = stack6.packageStack.size() - 1; i >= 0 ; i--){
                                Package temp4 = stack6.pop();
                                stack3.push(temp4);
                            }
                            for(int i = 0; i < stack3.packageStack.size(); i++){
                                if(stack3.packageStack.get(i).getRecipient().equals(name1)){
                                    giveString = "Give " + name1 + " " + Math.round(stack3.packageStack.get(i).getWeight()) + " lb package delivered on day " + stack3.packageStack.get(i).getArrivalDate() + "\n";                            }
                            }
                            if((count2-1) > 1){
                                System.out.println("Move " + (count2-1) + " packages from Stack 3 to floor");
                            }
                            else if((count2-1) == 1){
                                System.out.println("Move " + (count2-1) + " package from Stack 3 to floor");
                            }
                        }
                        if(temp2.charAt(0) == 'N' || temp2.charAt(0) == 'O' || temp2.charAt(0) == 'P' ||
                                temp2.charAt(0) == 'Q' || temp2.charAt(0) == 'R'){
                            for(int i = stack4.packageStack.size() - 1; i >= 0; i--){
                                if(!(stack4.packageStack.get(i).getRecipient().equals(name1))){
                                    Package temp3 = stack4.pop();
                                    stack6.push(temp3);
                                    count2++;
                                }
                            }
                            stack4.pop();
                            for(int i = stack6.packageStack.size() - 1; i >= 0 ; i--){
                                Package temp4 = stack6.pop();
                                stack4.push(temp4);
                            }
                            for(int i = 0; i < stack4.packageStack.size(); i++){
                                if(stack4.packageStack.get(i).getRecipient().equals(name1)){
                                    giveString = "Give " + name1 + " " + Math.round(stack4.packageStack.get(i).getWeight()) + " lb package delivered on day " + stack4.packageStack.get(i).getArrivalDate() + "\n";                            }
                            }
                            if((count2-1) > 1){
                                System.out.println("Move " + (count2-1) + " packages from Stack 4 to floor");
                            }
                            else if((count2-1) == 1){
                                System.out.println("Move " + (count2-1) + " package from Stack 4 to floor");
                            }
                        }
                        if(temp2.charAt(0) == 'S' || temp2.charAt(0) == 'T' || temp2.charAt(0) == 'U' || temp2.charAt(0) == 'V' ||
                                temp2.charAt(0) == 'W' || temp2.charAt(0) == 'X' || temp2.charAt(0) == 'Y' || temp2.charAt(0) == 'Z'){
                            for(int i = stack5.packageStack.size() - 1; i >= 0; i--){
                                if(!(stack5.packageStack.get(i).getRecipient().equals(name1))){
                                    Package temp3 = stack5.pop();
                                    stack6.push(temp3);
                                    count2++;
                                }
                            }
                            stack5.pop();
                            for(int i = stack6.packageStack.size() - 1; i >= 0 ; i--){
                                Package temp4 = stack6.pop();
                                stack5.push(temp4);
                            }
                            for(int i = 0; i < stack5.packageStack.size(); i++){
                                if(stack5.packageStack.get(i).getRecipient().equals(name1)){
                                    giveString = "Give " + name1 + " " + Math.round(stack5.packageStack.get(i).getWeight()) + " lb package delivered on day " + stack5.packageStack.get(i).getArrivalDate() + "\n";                            }
                            }
                            if((count2-1) > 1){
                                System.out.println("Move " + (count2-1) + " packages from Stack 5 to floor");
                            }
                            else if((count2-1) == 1){
                                System.out.println("Move " + (count2-1) + " package from Stack 5 to floor");
                            }
                        }
                        System.out.print(giveString);
                    }
                    catch (java.util.EmptyStackException e){
                        System.out.println("Empty Stack therefore cannot get packages.");
                    }
                    break;
                case "T":
                    arrivalDate++;
                    System.out.println("It is now day " + arrivalDate);
                    break;
                case "P":
                    System.out.println("Current Packages:");
                    System.out.println("--------------------------------");
                    System.out.print("Stack 1 (A-G):|");
                    if(stack1.isEmpty()){
                        System.out.println("empty.");
                    }
                    else{
                        System.out.println(stack1.toString());
                    }

                    System.out.print("Stack 2 (H-J):|");
                    if(stack2.isEmpty()){
                        System.out.println("empty.");
                    }
                    else{
                        System.out.println(stack2.toString());
                    }

                    System.out.print("Stack 3 (K-M):|");
                    if(stack3.isEmpty()){
                        System.out.println("empty.");
                    }
                    else{
                        System.out.println(stack3.toString());
                    }

                    System.out.print("Stack 4 (N-R):|");
                    if(stack4.isEmpty()){
                        System.out.println("empty.");
                    }
                    else{
                        System.out.println(stack4.toString());
                    }

                    System.out.print("Stack 5 (S-Z):|");
                    if(stack5.isEmpty()){
                        System.out.println("empty.");
                    }
                    else{
                        System.out.println(stack5.toString());
                    }

                    System.out.print("Floor:|");
                    if(stack6.isEmpty()){
                        System.out.println("empty.");
                    }
                    else{
                        System.out.println(stack6.toString());
                    }
                    break;
                case "M":
                    System.out.print("Please enter the source stack (enter 0 for floor): ");
                    int sourceStack = input.nextInt();
                    System.out.print("Please enter the destination stack: ");
                    int destinationStack = input.nextInt();
                    try{
                        if(sourceStack == 0){
//                        if(stack6.isEmpty()){
//                            System.out.println("Source stack is empty. Cannot move a package.");
//                        }
//                        else{
                            Package moved = stack6.pop();
                            if(destinationStack == 0){
                                stack6.push(moved);
                                System.out.println("Package moved successfully from stack 0 to stack 0");
                            }
                            if(destinationStack == 1){
                                stack1.push(moved);
                                System.out.println("Package moved successfully from stack 0 to stack 1");
                            }
                            if(destinationStack == 2){
                                stack2.push(moved);
                                System.out.println("Package moved successfully from stack 0 to stack 2");
                            }
                            if(destinationStack == 3){
                                stack3.push(moved);
                                System.out.println("Package moved successfully from stack 0 to stack 3");
                            }
                            if(destinationStack == 4){
                                stack4.push(moved);
                                System.out.println("Package moved successfully from stack 0 to stack 4");
                            }
                            if(destinationStack == 5){
                                stack5.push(moved);
                                System.out.println("Package moved successfully from stack 0 to stack 5");
                            }
                        }
//                    }
                        if(sourceStack == 1){
//                        if(stack1.isEmpty()){
//                            System.out.println("Source stack is empty. Cannot move a package.");
//                        }
//                        else{
                            Package moved = stack1.pop();
                            if(destinationStack == 0){
                                stack6.push(moved);
                                System.out.println("Package moved successfully from stack 1 to stack 0");
                            }
                            if(destinationStack == 1){
                                stack1.push(moved);
                                System.out.println("Package moved successfully from stack 1 to stack 1");
                            }
                            if(destinationStack == 2){
                                stack2.push(moved);
                                System.out.println("Package moved successfully from stack 1 to stack 2");
                            }
                            if(destinationStack == 3){
                                stack3.push(moved);
                                System.out.println("Package moved successfully from stack 1 to stack 3");
                            }
                            if(destinationStack == 4){
                                stack4.push(moved);
                                System.out.println("Package moved successfully from stack 1 to stack 4");
                            }
                            if(destinationStack == 5){
                                stack5.push(moved);
                                System.out.println("Package moved successfully from stack 1 to stack 5");
                            }
                        }
//                    }
                        if(sourceStack == 2){
//                        if(stack2.isEmpty()){
//                            System.out.println("Source stack is empty. Cannot move a package.");
//                        }
//                        else{
                            Package moved = stack2.pop();
                            if(destinationStack == 0){
                                stack6.push(moved);
                                System.out.println("Package moved successfully from stack 2 to stack 0");
                            }
                            if(destinationStack == 1){
                                stack1.push(moved);
                                System.out.println("Package moved successfully from stack 2 to stack 1");
                            }
                            if(destinationStack == 2){
                                stack2.push(moved);
                                System.out.println("Package moved successfully from stack 2 to stack 2");
                            }
                            if(destinationStack == 3){
                                stack3.push(moved);
                                System.out.println("Package moved successfully from stack 2 to stack 3");
                            }
                            if(destinationStack == 4){
                                stack4.push(moved);
                                System.out.println("Package moved successfully from stack 2 to stack 4");
                            }
                            if(destinationStack == 5){
                                stack5.push(moved);
                                System.out.println("Package moved successfully from stack 2 to stack 5");
                            }
//                        }
                        }
                        if(sourceStack == 3){
//                        if(stack3.isEmpty()){
//                            System.out.println("Source stack is empty. Cannot move a package.");
//                        }
//                        else{
                            Package moved = stack3.pop();
                            if(destinationStack == 0){
                                stack6.push(moved);
                                System.out.println("Package moved successfully from stack 3 to stack 0");
                            }
                            if(destinationStack == 1){
                                stack1.push(moved);
                                System.out.println("Package moved successfully from stack 3 to stack 1");
                            }
                            if(destinationStack == 2){
                                stack2.push(moved);
                                System.out.println("Package moved successfully from stack 3 to stack 2");
                            }
                            if(destinationStack == 3){
                                stack3.push(moved);
                                System.out.println("Package moved successfully from stack 3 to stack 3");
                            }
                            if(destinationStack == 4){
                                stack4.push(moved);
                                System.out.println("Package moved successfully from stack 3 to stack 4");
                            }
                            if(destinationStack == 5){
                                stack5.push(moved);
                                System.out.println("Package moved successfully from stack 3 to stack 5");
                            }
//                        }
                        }
                        if(sourceStack == 4){
//                        if(stack4.isEmpty()){
//                            System.out.println("Source stack is empty. Cannot move a package.");
//                        }
//                        else{
                            Package moved = stack4.pop();
                            if(destinationStack == 0){
                                stack6.push(moved);
                                System.out.println("Package moved successfully from stack 4 to stack 0");
                            }
                            if(destinationStack == 1){
                                stack1.push(moved);
                                System.out.println("Package moved successfully from stack 4 to stack 1");
                            }
                            if(destinationStack == 2){
                                stack2.push(moved);
                                System.out.println("Package moved successfully from stack 4 to stack 2");
                            }
                            if(destinationStack == 3){
                                stack3.push(moved);
                                System.out.println("Package moved successfully from stack 4 to stack 3");
                            }
                            if(destinationStack == 4){
                                stack4.push(moved);
                                System.out.println("Package moved successfully from stack 4 to stack 4");
                            }
                            if(destinationStack == 5){
                                stack5.push(moved);
                                System.out.println("Package moved successfully from stack 4 to stack 5");
                            }
//                        }
                        }
                        if(sourceStack == 5) {
//                        if(stack5.isEmpty()){
//                            System.out.println("Source stack is empty. Cannot move a package.");
//                        }
//                        else{
                            Package moved = stack5.pop();
                            if (destinationStack == 0) {
                                stack6.push(moved);
                                System.out.println("Package moved successfully from stack 5 to stack 0");
                            }
                            if (destinationStack == 1) {
                                stack1.push(moved);
                                System.out.println("Package moved successfully from stack 5 to stack 1");
                            }
                            if (destinationStack == 2) {
                                stack2.push(moved);
                                System.out.println("Package moved successfully from stack 5 to stack 2");
                            }
                            if (destinationStack == 3) {
                                stack3.push(moved);
                                System.out.println("Package moved successfully from stack 5 to stack 3");
                            }
                            if (destinationStack == 4) {
                                stack4.push(moved);
                                System.out.println("Package moved successfully from stack 5 to stack 4");
                            }
                            if (destinationStack == 5) {
                                stack5.push(moved);
                                System.out.println("Package moved successfully from stack 5 to stack 5");
                            }
//                       }
                        }
                    }
                    catch(java.util.EmptyStackException e){
                        System.out.println("Source stack is empty. Cannot move a package.");
                    }
                    break;
                case "F":
                    try{
                        if(!(stack1.isEmpty())){
                            String tempName1 = stack1.peek().getRecipient().toUpperCase();
                            if(!(tempName1.charAt(0) == 'A' || tempName1.charAt(0) == 'B' || tempName1.charAt(0) == 'C' || tempName1.charAt(0) == 'D' ||
                                    tempName1.charAt(0) == 'E' || tempName1.charAt(0) == 'F' || tempName1.charAt(0) == 'G')){
                                Package temp5 = stack1.pop();
                                String temp6 = temp5.getRecipient().toUpperCase();
                                if(temp6.charAt(0) == 'H' || temp6.charAt(0) == 'I' || temp6.charAt(0) == 'J'){
                                    stack2.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'K' || temp6.charAt(0) == 'L' || temp6.charAt(0) == 'M'){
                                    stack3.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'N' || temp6.charAt(0) == 'O' || temp6.charAt(0) == 'P' ||
                                        temp6.charAt(0) == 'Q' || temp6.charAt(0) == 'R'){
                                    stack4.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'S' || temp6.charAt(0) == 'T' || temp6.charAt(0) == 'U' || temp6.charAt(0) == 'V' ||
                                        temp6.charAt(0) == 'W' || temp6.charAt(0) == 'X' || temp6.charAt(0) == 'Y' || temp6.charAt(0) == 'Z'){
                                    stack5.packageStack.push(temp5);
                                }
                            }
                        }
                        if(!(stack2.isEmpty())){
                            String tempName2 = stack2.peek().getRecipient().toUpperCase();
                            if(!(tempName2.charAt(0) == 'H' || tempName2.charAt(0) == 'I' || tempName2.charAt(0) == 'J')){
                                Package temp5 = stack2.pop();
                                String temp6 = temp5.getRecipient().toUpperCase();
                                if(temp6.charAt(0) == 'A' || temp6.charAt(0) == 'B' || temp6.charAt(0) == 'C' || temp6.charAt(0) == 'D' ||
                                        temp6.charAt(0) == 'E' || temp6.charAt(0) == 'F' || temp6.charAt(0) == 'G') {
                                    stack1.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'K' || temp6.charAt(0) == 'L' || temp6.charAt(0) == 'M'){
                                    stack3.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'N' || temp6.charAt(0) == 'O' || temp6.charAt(0) == 'P' ||
                                        temp6.charAt(0) == 'Q' || temp6.charAt(0) == 'R'){
                                    stack4.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'S' || temp6.charAt(0) == 'T' || temp6.charAt(0) == 'U' || temp6.charAt(0) == 'V' ||
                                        temp6.charAt(0) == 'W' || temp6.charAt(0) == 'X' || temp6.charAt(0) == 'Y' || temp6.charAt(0) == 'Z'){
                                    stack5.packageStack.push(temp5);
                                }
                            }
                        }
                        if(!(stack3.isEmpty())){
                            String tempName3 = stack3.peek().getRecipient().toUpperCase();
                            if(!(tempName3.charAt(0) == 'K' || tempName3.charAt(0) == 'L' || tempName3.charAt(0) == 'M')){
                                Package temp5 = stack3.pop();
                                String temp6 = temp5.getRecipient().toUpperCase();
                                if(temp6.charAt(0) == 'A' || temp6.charAt(0) == 'B' || temp6.charAt(0) == 'C' || temp6.charAt(0) == 'D' ||
                                        temp6.charAt(0) == 'E' || temp6.charAt(0) == 'F' || temp6.charAt(0) == 'G') {
                                    stack1.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'H' || temp6.charAt(0) == 'I' || temp6.charAt(0) == 'J'){
                                    stack2.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'N' || temp6.charAt(0) == 'O' || temp6.charAt(0) == 'P' ||
                                        temp6.charAt(0) == 'Q' || temp6.charAt(0) == 'R'){
                                    stack4.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'S' || temp6.charAt(0) == 'T' || temp6.charAt(0) == 'U' || temp6.charAt(0) == 'V' ||
                                        temp6.charAt(0) == 'W' || temp6.charAt(0) == 'X' || temp6.charAt(0) == 'Y' || temp6.charAt(0) == 'Z'){
                                    stack5.packageStack.push(temp5);
                                }
                            }
                        }
                        if(!(stack4.isEmpty())){
                            String tempName4 = stack4.peek().getRecipient().toUpperCase();
                            if(!(tempName4.charAt(0) == 'N' || tempName4.charAt(0) == 'O' || tempName4.charAt(0) == 'P' ||
                                    tempName4.charAt(0) == 'Q' || tempName4.charAt(0) == 'R')){
                                Package temp5 = stack4.pop();
                                String temp6 = temp5.getRecipient().toUpperCase();
                                if(temp6.charAt(0) == 'A' || temp6.charAt(0) == 'B' || temp6.charAt(0) == 'C' || temp6.charAt(0) == 'D' ||
                                        temp6.charAt(0) == 'E' || temp6.charAt(0) == 'F' || temp6.charAt(0) == 'G') {
                                    stack1.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'H' || temp6.charAt(0) == 'I' || temp6.charAt(0) == 'J'){
                                    stack2.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'K' || temp6.charAt(0) == 'L' || temp6.charAt(0) == 'M'){
                                    stack3.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'S' || temp6.charAt(0) == 'T' || temp6.charAt(0) == 'U' || temp6.charAt(0) == 'V' ||
                                        temp6.charAt(0) == 'W' || temp6.charAt(0) == 'X' || temp6.charAt(0) == 'Y' || temp6.charAt(0) == 'Z'){
                                    stack5.packageStack.push(temp5);
                                }
                            }
                        }
                        if(!(stack5.isEmpty())){
                            String tempName5 = stack5.peek().getRecipient().toUpperCase();
                            if(!(tempName5.charAt(0) == 'S' || tempName5.charAt(0) == 'T' || tempName5.charAt(0) == 'U' || tempName5.charAt(0) == 'V' ||
                                    tempName5.charAt(0) == 'W' || tempName5.charAt(0) == 'X' || tempName5.charAt(0) == 'Y' || tempName5.charAt(0) == 'Z')){
                                Package temp5 = stack5.pop();
                                String temp6 = temp5.getRecipient().toUpperCase();
                                if(temp6.charAt(0) == 'A' || temp6.charAt(0) == 'B' || temp6.charAt(0) == 'C' || temp6.charAt(0) == 'D' ||
                                        temp6.charAt(0) == 'E' || temp6.charAt(0) == 'F' || temp6.charAt(0) == 'G') {
                                    stack1.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'H' || temp6.charAt(0) == 'I' || temp6.charAt(0) == 'J'){
                                    stack2.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'K' || temp6.charAt(0) == 'L' || temp6.charAt(0) == 'M'){
                                    stack3.packageStack.push(temp5);
                                }
                                if(temp6.charAt(0) == 'N' || temp6.charAt(0) == 'O' || temp6.charAt(0) == 'P' ||
                                        temp6.charAt(0) == 'Q' || temp6.charAt(0) == 'R'){
                                    stack4.packageStack.push(temp5);
                                }
                            }
                        }
                        System.out.println("Misplaced packages moved to floor.");
                    }
                    catch(java.util.EmptyStackException e){
                        System.out.println("Misplaced packages moved to floor.");
                    }


                    break;
                case "L":
                    System.out.print("Please enter the recipient name: ");
                    String name = input.nextLine().trim();
                    int count = 0;
                    String temp1 = name.toUpperCase();
                    StringBuilder str = new StringBuilder();

                    if(temp1.charAt(0) == 'A' || temp1.charAt(0) == 'B' || temp1.charAt(0) == 'C' || temp1.charAt(0) == 'D' ||
                            temp1.charAt(0) == 'E' || temp1.charAt(0) == 'F' || temp1.charAt(0) == 'G'){
                        for(int i = 0; i < stack1.packageStack.size(); i++){
                            if(stack1.packageStack.get(i).getRecipient().equals(name)){
                                count++;
                                str.append("\nPackage " + count + " is in Stack 1, it was delivered on day " + stack1.packageStack.get(i).getArrivalDate() + ", and weighs " + Math.round(stack1.packageStack.get(i).getWeight()) + " lbs");
                            }
                        }
                    }
                    if(temp1.charAt(0) == 'H' || temp1.charAt(0) == 'I' || temp1.charAt(0) == 'J'){
                        for(int i = 0; i < stack2.packageStack.size(); i++){
                            if(stack2.packageStack.get(i).getRecipient().equals(name)){
                                count++;
                                str.append("\nPackage " + count + " is in Stack 2, it was delivered on day " + stack2.packageStack.get(i).getArrivalDate() + ", and weighs " + Math.round(stack2.packageStack.get(i).getWeight()) + " lbs");
                            }
                        }
                    }
                    if(temp1.charAt(0) == 'K' || temp1.charAt(0) == 'L' || temp1.charAt(0) == 'M'){
                        for(int i = 0; i < stack3.packageStack.size(); i++){
                            if(stack3.packageStack.get(i).getRecipient().equals(name)){
                                count++;
                                str.append("\nPackage " + count + " is in Stack 3, it was delivered on day " + stack3.packageStack.get(i).getArrivalDate() + ", and weighs " + Math.round(stack3.packageStack.get(i).getWeight()) + " lbs");
                            }
                        }
                    }
                    if(temp1.charAt(0) == 'N' || temp1.charAt(0) == 'O' || temp1.charAt(0) == 'P' ||
                            temp1.charAt(0) == 'Q' || temp1.charAt(0) == 'R'){
                        for(int i = 0; i < stack4.packageStack.size(); i++){
                            if(stack4.packageStack.get(i).getRecipient().equals(name)){
                                count++;
                                str.append("\nPackage " + count + " is in Stack 4, it was delivered on day " + stack4.packageStack.get(i).getArrivalDate() + ", and weighs " + Math.round(stack4.packageStack.get(i).getWeight()) + " lbs");
                            }
                        }
                    }
                    if(temp1.charAt(0) == 'S' || temp1.charAt(0) == 'T' || temp1.charAt(0) == 'U' || temp1.charAt(0) == 'V' ||
                            temp1.charAt(0) == 'W' || temp1.charAt(0) == 'X' || temp1.charAt(0) == 'Y' || temp1.charAt(0) == 'Z'){
                        for(int i = 0; i < stack5.packageStack.size(); i++){
                            if(stack5.packageStack.get(i).getRecipient().equals(name)){
                                count++;
                                str.append("\nPackage " + count + " is in Stack 5, it was delivered on day " + stack5.packageStack.get(i).getArrivalDate() + ", and weighs " + Math.round(stack5.packageStack.get(i).getWeight()) + " lbs");
                            }
                        }
                    }
                    if(count > 1){
                        System.out.print(name + " has " + count + " packages total.");
                        System.out.println(str);
                    }
                    else if(count == 1){
                        System.out.print(name + " has " + count + " package total.");
                        System.out.println(str);
                    }
                    else if(count == 0){
                        System.out.println("No packages found for John.");
                    }
                    break;
                case "E":
                    try{
                        for(int i = 0; i < stack6.packageStack.size(); i++){
                            stack6.pop();
                        }
                        System.out.println("The floor has been emptied. Mr. Trash Can is no longer hungry.");
                    }
                    catch (java.util.EmptyStackException e){
                        System.out.println("The floor has been emptied. Mr. Trash Can is no longer hungry.");
                    }


                    break;
                case "Q":
                    System.out.println("Use Amazon Locker next time.");
                    System.out.println("(A-G, H-J, K-M, N-R, S-Z)");
                    System.exit(0);
                    break;
            }
        }
    }
}















