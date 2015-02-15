package TextManipulator;

import java.io.*;
import java.util.Scanner;

class CLI {
    public Scanner scanner = new Scanner(System.in);
    public String text;
    public void StartCLI(){
        System.out.println("Welcome to the Plain+Simple text manipulator (CLI mode)\n\n");
        LoadFile();
        /* we need a way of catching errors if LoadFile fails) */
        System.out.println(i18n.messages.getString("function_prompt") + "\n");
        String userInput = scanner.nextLine();
        switch(userInput) {
            case "help": OutputFunctionsList();
        }
    }
    public void LoadFile() {
        System.out.println("Please enter the file name of the text file you would like to manipulate: ");
        Scanner scanner = new Scanner(System.in);
        String file_path = scanner.nextLine();
        /* import file_path text file into string called text */
        text = new Scanner(file_path).useDelimiter("\\Z").next();
    }
    void OutputFunctionsList() {
        System.out.println("\naddprefix" + i18n.messages.getString("addprefix_description"));
        System.out.println("\naddsuffix" + i18n.messages.getString("addsuffix_description"));
        System.out.println("\nremoveduplicatelines" + i18n.messages.getString("removeduplicatelines_description"));
        System.out.println("\nremovelinescontaining" + i18n.messages.getString("removelinescontaining_description"));
        System.out.println("\nscramblelines" + i18n.messages.getString("scramblelines_description"));
        System.out.println("\nsortlinesalphabetically" + i18n.messages.getString("sortlinesalphabetically_description"));
        System.out.println("\nsortlinesbysize" + i18n.messages.getString("sortlinesbysize_description"));
        System.out.println("\nnumberlines" + i18n.messages.getString("numberlines_description"));
        System.out.println("\nremoveemptylines" + i18n.messages.getString("removeemptylines_description"));
        System.out.println("\nmergetext" + i18n.messages.getString("mergetext_description"));
        System.out.println("\nfindreplace" + i18n.messages.getString("findreplace_description"));
        System.out.println("\nremoveargument" + i18n.messages.getString("removeargument_description"));
        System.out.println("\ncommaseparatevalues" + i18n.messages.getString("commaseparatevalues_description"));
        System.out.println("\nlineseparatevalues" + i18n.messages.getString("lineseparatevalues_description"));
        System.out.println("\nsplitsentences" + i18n.messages.getString("splitsentences_description"));
        System.out.println("\ncomparelines" + i18n.messages.getString("comparelines_description"));
        System.out.println("\nremovepunctuation" + i18n.messages.getString("removepunctuation_description"));
        System.out.println("\nuppercase" + i18n.messages.getString("uppercase_description"));
        System.out.println("\nlowercase" + i18n.messages.getString("lowercase_description"));
        System.out.println("\nprint" + i18n.messages.getString("print_description"));

    }
    public void ModifySettings() {

    }
}
