package plainsimple;

import plainsimple.util.TextUtil;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/* Class that handles textfiles, files that can be read and written
 * with Strings */
public class TextFile {
  private File file;

 /* public String getPath() {
        return file_path.toString();
  }
  public String getFileText() {
        return file_text;
  }
  public String getFileName() {
        return file_name;
  } */

  /* Constructor using file */
  public TextFile(File file) {
      this.file = file;
  }

  /* Constructor using path as a String */
  public TextFile(String path) {
      this.file = new File(path);
  }

  /* Constructor using path */
  public TextFile(Path path) {
      this.file = new File(path.toString());
  }

  /* Returns whether this file exists as a file and can be read */
  public boolean isValid() {
      return file.isFile() && file.canRead();
  }

  /* Writes file
   * @param text String to write to file */
  public void setText(String text) {
      writeFile(text);
  }

  /* Writes file by "expanding" the array into a single String
   * and writing that String
   * @param text String array to write to file */
  public void setText(String[] text) {
    String file_text = "";
    for(int i = 0; i < text.length; i++)
        file_text += text[i];
    writeFile(file_text);
  }

  /* Appends String to file
   * @param append String to add to the  end of the file */
  public void appendText(String append) {
    writeFile(readFile() + append);
  }

  /* Removes all text from the file */
  public void clear() {
      writeFile("");
  }

  /* Reads file and returns file contents as String
   * @return file contents, null if file could not be read */
  public String readFile() {
      /* Try creating a BufferedReader using the file's path */
      try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getPath()))) {
          String line;
          String text = "";
          int line_counter = 0;
          while ((line = reader.readLine()) != null) {
              if(line_counter == 0)
                  text = line;
              else
                  text += "\n" + line;
              line_counter++;
          }
          return text;
    } catch (IOException e) {
          return null;
    }
  }
  /* Writes file with String
   * @param file_text String to write to the file */
  public boolean writeFile(String file_text) {
    /* Try creating a BufferedWriter using the file's path */
    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getPath()))) {
      writer.write(file_text, 0, file_text.length());
      return true;
    } catch (IOException e) {
      return false;
    }
  }

  /* Deletes file */
  public boolean delete() {
    return file.delete();
  }

  /* Reads file line by line and returns an arrayList of lines
   * @return an arrayList containing filetext as lines, or null if file
    * couldn't be read */
  public ArrayList<String> ReadsLines() {
      ArrayList<String> file_lines = new ArrayList<String> ();
      try {
          BufferedReader reader = new BufferedReader(new FileReader(file));
          String line;
          while ((line = reader.readLine()) != null) {
              file_lines.add(line);
          }
          return file_lines;
      } catch(IOException e) {
          return null;
      }
  }

  /* Pastes clipboard contents into file
   * @return whether clipboard contents were accessed and written successfully */
  public boolean pasteIntoFile() { // Todo: fix bug where linebreaks are lost
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        /* get contents from clipboard (stored in a Transferable, which manages data transfer) */
        Transferable contents = clipboard.getContents(null);
        /* if contents are transferable, the Transferable will not be null and will be the
        correct DataFlavor (String). DataFlavor refers to the type of object something is */
        boolean hasTransferableText =
                (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasTransferableText) {
            try {
                return writeFile((String)contents.getTransferData(DataFlavor.stringFlavor));
            } catch (UnsupportedFlavorException|IOException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    /* prints contents of file in a presentable fashion */
    public void printFile() {
        System.out.println("File contents: ");
        System.out.println("---------------------------------------------------------");
        System.out.println(this.readFile());
        System.out.println("---------------------------------------------------------");
    }
    /* prints contents of file with numbered lines */
    public void printLines() {
        TextUtil manip = new TextUtil();
        System.out.println("Lines: ");
        System.out.println("---------------------------------------------------------");
        System.out.println(manip.numberObjects(manip.splitIntoLines(this.readFile()).get(1), "", ". "));
        System.out.println("---------------------------------------------------------");
    }
    /* prints contents of file with words numbered and on separate lines */
    public void printWords() {
        TextUtil manip = new TextUtil();
        System.out.println("Words: ");
        System.out.println("---------------------------------------------------------");
        System.out.println(manip.numberObjects(manip.splitIntoWords(this.readFile()).get(1), "", ". "));
        System.out.println("---------------------------------------------------------");
    }
    /* prints contents of file with chars numbered and on separate lines */
    public void printChars() { // todo: improve this function
        TextUtil manip = new TextUtil();
        System.out.println("Chars: ");
        System.out.println("---------------------------------------------------------");
        System.out.println(manip.numberObjects(manip.splitIntoChars(this.readFile()).get(1), "", ". "));
        System.out.println("---------------------------------------------------------");
    }
}
