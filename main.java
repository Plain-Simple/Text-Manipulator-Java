package textfunctions;
import java.io.*;
import java.util.Vector;
import java.util.Arrays;
import java.lang.Character;
public class TextManipulator {
    public static void main(String[] args) {
       /* String text = "This is a test of the Plain+Simple TextManipulator" +
                "\n this is line two.";
        boolean[] analyzetext_settings = new boolean[6]; /* create array of booleans to store settings for the "AnalyzeText" function */
        /*boolean file_loaded = LoadSettings(analyzetext_settings);
        if(!(file_loaded))
            DefaultSettings(analyzetext_settings);
        AnalyzeText(text, analyzetext_settings);
        boolean[] success = new boolean[1]; /* this can be used in functions to return true or false */
        /*text = ReadFromFile("TextManipulator_Test", text, success);
        if(success[0]) {
            LineAnalysis(text);
            Println(SortLinesBySize(text));
            Println(RemoveEmptyLines(text));
            Println(NumberLines(text, "", ") "));
        }*/
    }

    /* runs each sub-function user has chosen under "AnayzeText" function settings */
    public static void AnalyzeText(String text, boolean analyzetext_settings[]) {
        if (analyzetext_settings[0])
            Println("Text has " + WordCount(text) + " word(s).");
        if (analyzetext_settings[1])
            Println("Text has " + CharCount(text) + " character(s).");
        if (analyzetext_settings[2])
            Println("Text has " + LineCount(text) + " line(s).");
        if (analyzetext_settings[3])
            Println("Text has " + SentenceCount(text) + " sentence(s).");
        if (analyzetext_settings[4])
            WordFrequency(text);
        if (analyzetext_settings[5])
            CharFrequency(text);
    }
    /* initializes all variables with default settings and creates the "TextManipulator_Settings" file */
    public static void DefaultSettings(boolean analyzetext_settings[]) {
        try {
            FileWriter file = new FileWriter("TextManipulator_Settings");
            BufferedWriter write_settings = new BufferedWriter(file);
            write_settings.write("#Line 1: AnalyzeText Settings: WordCount, CharCount, LineCount, SentenceCount, WordFrequency, CharFrequency\n");
            write_settings.write("1,1,1,1,1,1\n"); /* sets values on file to true by default */
            write_settings.close();
        } catch (IOException e) {
            Print("Error writing default settings file\n");
        }
        for(int i = 0; i < 6; i++)
            analyzetext_settings[i] = true; /* set all values to true by default */
    }

    public static boolean LoadSettings(boolean analyzetext_settings[]) {
        boolean load = true;
        try {
            FileReader file = new FileReader("TextManipulator_Settings");
            BufferedReader read_settings = new BufferedReader(file);
            String line = "";
            int line_counter = 1;
            while((line = read_settings.readLine()) != null) {
                if(line_counter == 1) {/* line 1: load settings for AnalyzeText */
                    /* line is "1,1,1,1,1,1" so we can read it in easily. Each value is parsed from String to boolean for easy use */
                    analyzetext_settings[0] = CharToBoolean(line.charAt(0));
                    analyzetext_settings[1] = CharToBoolean(line.charAt(2));
                    analyzetext_settings[2] = CharToBoolean(line.charAt(4));
                    analyzetext_settings[3] = CharToBoolean(line.charAt(6));
                    analyzetext_settings[4] = CharToBoolean(line.charAt(8));
                    analyzetext_settings[5] = CharToBoolean(line.charAt(10));
                }
                line_counter++;
            }
        } catch (IOException e) {
            Print("Error reading settings file\n");
            load = false;
        }
        return load; /* returns whether "TextManipulator_Settings" was accessed and read */
    }
    /* updates "TextManipulator_Settings" with new values from program - will be run every time the user changes settings */
    public static boolean UpdateSettings(boolean[] analyzetext_settings) {
        boolean success = true;
        try {
            FileWriter file = new FileWriter("TextManipulator_Settings");
            BufferedWriter write_settings = new BufferedWriter(file);
            /* write settings to file (in the correct order), first converting each value to a char and comma-separating them */
            write_settings.write(BooleanToChar(analyzetext_settings[0]) + "," + BooleanToChar(analyzetext_settings[1]) +
                    "," + BooleanToChar(analyzetext_settings[2]) + "," + BooleanToChar(analyzetext_settings[3]) + "," +
                    BooleanToChar(analyzetext_settings[4]) + "," + BooleanToChar(analyzetext_settings[5]));
            write_settings.newLine();
            write_settings.close();
        } catch(IOException e) {
            Print("Error writing to file\n");
            success = false;
        }
        return success;
    }
    public String ReadFromFile(String file_name, boolean[] success) {
        String text = ""; /* empty variable text */
        try {
            success[0] = true;
            FileReader file = new FileReader(file_name);
            BufferedReader read_file = new BufferedReader(file);
            String line = "";
            while((line = read_file.readLine()) != null) {
                text = text + line + "\n"; /* need to include a newline, otherwise everything will be made into one line */
            }
        } catch(IOException e) {
            error_message.setText("Error reading file \"" + file_name + "\"");
            success[0] = false;
        }
        return text;
    }
    /* returns false if '0', true if anything else. Used for transferring variables from "TextManipulator_Settings to
     * the program */
    public static boolean CharToBoolean(char c) {
        if(c == '0')
            return false;
        else
            return true;
    }
    /* returns '0' if false, '1' if true. Used for transferring variables from program to "TextManipulator_Settings" */
    public static char BooleanToChar(boolean b) {
        if(b == false)
            return '0';
        else
            return '1';
    }

    public static int CharCount(String text) {
        int char_count = text.replace("\n", "").length();
        return char_count;
    }

    public static int WordCount(String text) {
        int word_count = text.length()
                - text.replace(" ", "").replace("\n", "").length() + 1;
        return word_count;
    }

    public static int LineCount(String text) {
        int line_count = text.length() - text.replace("\n", "").length() + 1; /// needs to be tested and possibly corrected
        return line_count;
    }

    public static int SentenceCount(String text) {
        int sentence_count = text.length()
                - text.replace(".", "").replace("?", "").replace("!", "")
                .length();
        if(sentence_count == 0)
            sentence_count++; /* it has to be at least one sentence, even though it may not be grammatically complete */
        return sentence_count;
    }

    public static void WordFrequency(String text) {

    }

    public static void CharFrequency(String text) {

    }
    /* adds prefix and suffix to each line */
    public static String AddPrefixSuffix(String text, String prefix, String suffix) {
        //String delims = "[\\r\\n]+"; /* splits text into separate lines */
        //String[] lines = text.split(delims); /* create an array that holds each individual line */
        String[] lines = text.split("\\r?\\n"); /* create an array that holds each individual line */
        text = ""; /* clear variable once it has been split into lines*/
        for(int i = 0; i < lines.length; i++)
            text = text + prefix + lines[i] + suffix + "\n"; /* add each line to text with prefix and suffix */
        return text;
    }
    public static String RemoveDuplicateLines(String text) { /// a little messy, but works. Feel free to refactor
        Vector<Integer> duplicates = new Vector<Integer> (0, 1);
        String[] lines = text.split("\\r?\\n"); /* create an array that holds each individual line */
        text = ""; /* clear variable once it has been split into lines*/
        for(int i = 0; i < lines.length; i++) {
            for(int j = i + 1; j < lines.length; j++) { /* check to see if any of the later elements match */
                if(lines[j].equals(lines[i])) {/* duplicate found */
                    duplicates.addElement(j); /* add element position to vector */
                }
            }
        }
        Vector<String> new_lines = new Vector<String> (0,1); /* vector to hold the non-duplicate lines */
        for(int i = 0; i < lines.length; i++) {
            boolean copy_element = true; /* true if element is not a duplicate */
            for(int j = 0; j < duplicates.size(); j++) {
                if(i == duplicates.get(j))
                    copy_element = false;
            }
            if(copy_element)
                new_lines.addElement(lines[i]);
        }
        for(int i = 0; i < new_lines.size(); i++)
            text = text + new_lines.get(i) + "\n";
        return text;
    }
    public static String RemoveLinesContaining(String text, String remove) {
        String[] lines = text.split("\\r?\\n"); /* create an array that holds each individual line */
        text = ""; /* clear variable once it has been split into lines*/
        for(int i = 0; i < lines.length; i++) { /* for each line... */
            if(lines[i].indexOf(remove) < 0) /* could not find String remove in line */
                text = text + lines[i] + "\n";
        }
        return text;
    }
    public static String ScrambleLines(String text) {
        String[] lines = text.split("\\r?\\n"); /* create an array that holds each individual line */
        Vector<String> lines_vector = new Vector(Arrays.asList(lines)); /* copy array to vector for easier manipulation */
        text = ""; /* clear variable once it has been split into lines*/
        while(lines_vector.size() > 0) { /* runs until all lines have been copied */
            int line_number = GenerateRandomNumber(lines_vector.size() - 1); /* generate random number within range of vector */
            text = text + lines_vector.get(line_number) + "\n"; /* copy corresponding element to text */
            lines_vector.remove(line_number); /* remove the element from the vector so it cannot be copied again */
        }
        return text;
    }
    public static String SortLinesAlphabetically(String text) {
        String[] lines = text.split("\\r?\\n"); /* create an array that holds each individual line */
        text = ""; /* clear variable once it has been split into lines*/
        Arrays.sort(lines);
        for(int i = 0; i < lines.length; i++)
            text = text + lines[i] + "\n";
        return text;
    }
    public static String SortLinesBySize(String text) {
        String[] lines = text.split("\\r?\\n"); /* create an array that holds each individual line */
        text = ""; /* clear variable once it has been split into lines*/
        for(int i = 1; i < lines.length; i++) { /* start at second element */
            int num = 1;
            String compare = lines[i];
            while(num <= i && compare.length() < lines[i - num].length()) { /* keeps looping while a smaller line
                exists behind the current element and num doesn't cause an arrayindexoutofbounds exception */
                lines[i - num + 1] = lines[i - num]; /* move larger element one to the right */
                lines[i - num] = compare; /* move compare one to the left */
                num++;
            }
        }
        for(int i = 0; i < lines.length; i++)
            text = text + lines[i] + "\n";
        return text;
    }
    public static String NumberLines(String text, String prefix, String suffix) {
        /* prefix is what goes before the number itself, suffix is what goes after the number but before the line.
        For example: "1. " has no prefix and ". " as the suffix */
        String[] lines = text.split("\\r?\\n"); /* create an array that holds each individual line */
        text = ""; /* clear variable once it has been split into lines*/
        for(int i = 0; i < lines.length; i++) {
            text = text + prefix + (i + 1) + suffix + lines[i] + "\n";
        }
        return text;
    }
    public static String RemoveEmptyLines(String text) {
        String[] lines = text.split("\\r?\\n"); /* create an array that holds each individual line */
        text = ""; /* clear variable once it has been split into lines*/
        for(int i = 0; i < lines.length; i++) {
            boolean copy = false;
            for(int j = 0; j < lines[i].length(); j++) {
                if(!(Character.isWhitespace(lines[i].charAt(j)))) {/* condition will be true if a character in lines[i] is NOT whitespace */
                    copy = true;
                    break;
                }
            }
            if(copy)
                text = text + lines[i] + "\n";
        }
        return text;
    }
    public static String MergeText(String text, String text2) {
        String[] lines = text.split("\\r?\\n");
        String[] lines2 = text2.split("\\r?\\n");
        String new_text = "";
        for(int i = 0; i < lines.length; i++) {
            if(i < lines2.length) /* will prevent lines2 from going out of bounds if it is smaller than lines */
                new_text = new_text + lines[i] + lines2[i] + "\n";
            else
                new_text = new_text + lines[i] + "\n"; /* all elements of lines2 have been transferred */
        }
        if(lines2.length > lines.length) {
            for(int i = lines.length; i < lines2.length; i++) /* merge any remaining elements from lines2 */
                new_text = new_text + lines2[i] + "\n";
        }
        return new_text;
    }
    public static String FindReplace(String text, String find, String replace) { /// just the basic algorithm for now. May need to be fixed.
        int instances = 0;
        while(text.indexOf(find) > -1) { /* runs until String find is no longer found */ /// no longer sure if this will work correctly, although testing was fine.
            text = text.substring(0, text.indexOf(find)) + replace + text.substring(text.indexOf(find) + find.length(), text.length());
            instances++;
        }
        return text;
    }
    /* removes all instances of 'argument' from 'text' */
    public static String RemoveArgument(String argument, String text) {
        String new_text = "";
        Vector<Integer> locations = new Vector<Integer> (0,1); /* will be used to store the indexes where argument is found */
        int from_index = 0;
        while(text.indexOf(argument, from_index) > -1) {
            int index = text.indexOf(argument, from_index);
            locations.addElement(index); /* store locations of all instances */
            from_index = index + argument.length(); /* increment from_index so it won't keep finding the same string over and over */
        }
        int j = 0, argument_length = argument.length();
        for(int i = 0; i < text.length(); i++) {
            if(j < locations.size() && i == locations.get(j)) { /* i has reached one of the instances */
                i = i + argument_length - 1; /* increment i to skip the instance */
                j++;
            }
            else
                new_text = new_text + text.charAt(i);
        }
        return new_text;
    }
    public static String CommaSeparateValues(String text) {
        String new_text = "";
        for(int i = 0; i < text.length(); i++)
            if(text.charAt(i) == ' ')
                new_text = new_text + ",";
            else
                new_text = new_text + text.charAt(i);
        String new_text1 = "";
        for(int i = 0; i < new_text.length() - 1; i++) {
            if(!(new_text.charAt(i) == ',' && new_text.charAt(i + 1) == ',')) /* remove duplicate commas */
                new_text1 = new_text1 + new_text.charAt(i);
        }
        return new_text1;
    }
    public static String LineSeparateValues(String text, char separator) { /// mistake when 'separator' is at the beginning of a line
        String new_text = "", word = "";
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != separator)
                word = word + text.charAt(i);
            else if(word != "") { /* this avoids empty line breaks when there is more than one separator in a row */
                new_text = new_text + word + "\n"; /* add 'word' and a newline */
                word = ""; /* reset word */
            }
        }
        return new_text + word; /* make sure to get the last word */
    }
    //public static void LineAnalysis(String text) {
    //    String[] lines = text.split("\\r?\\n");
    //    for(int i = 0; i < lines.length; i++) {
    //        Println("Line " + (i + 1) + ": " + WordCount(lines[i]) + " word(s), " + CharCount(lines[i]) + " character(s), "
    //        + SentenceCount(lines[i]) + " sentence(s).");
    //    }
    //}
    /* puts each individual sentence on a separate line */
    public static String SplitSentences(String text) {
        String new_text = "";
        return new_text;
    }
    public static void CompareLines(String text, int line_number1, int line_number2) {

    }
    /* generates a random number between 0 and 'upper_bound' inclusive */
    public static int GenerateRandomNumber(int upper_bound) { /// I'm pretty sure there's a java.util.Random library we can use
        //int random = (int) (Math.floor(Math.random() * (upper_bound + 1)));
        return (int) Math.floor(Math.random() * (upper_bound + 1));
    }
    /* removes all non-letter and non-numbers, leaves spaces */
    public static String RemovePunctuation(String text) {
        String new_text = "";
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(!((c > 32 && c < 48) || (c > 57 && c < 65) || (c > 90 && c < 97) || (c > 122 && c < 127)))
                new_text = new_text + c;
        }
        return new_text;
    }


    public static String ForceUppercase(String text) {return text.toUpperCase();}
    public static String ForceLowercase(String text) {return text.toLowerCase();}
    public static void Print(String s) { System.out.print(s); }
    public static void Println(String s) { System.out.println(s); }
}
