package plainsimple.textmanipulator;

import c10n.C10N;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Plain+Simple TextManipulator settings and global variable management */
class Settings {
    private final Messages messages = C10N.get(Messages.class, Locale.getDefault());
    private ArrayList<String> settings = new ArrayList<>();
    /* name of file where data is stored */
    private String file_name = "TextManipulator_Settings";
    public ArrayList<String> getSettings() { return settings; }
    public Settings() { /* checks to see if data file exists */
        if(!new File(file_name).isFile())
            setDefaultSettings(); /* if not, creates default data file */
    }
    /* adds batch to data file */
    public void addBatch(FileBatch add) {
        TextFile data_file = new TextFile(file_name);
        if(data_file.isValid()) {
            data_file.appendText("\n----------\n" + add.toString());
        } else
            setDefaultSettings();
    }
    /* finds batch in data file and removes it */
    public boolean removeBatch(FileBatch remove) { // todo: testing
        TextFile data_file = new TextFile(file_name);
        /* read in data file and split into an array of lines */
        ArrayList<String> data = data_file.getLines();
        int index = data.indexOf(remove.getName());
        if(index <= 0) /* old filebatch not found in data file */
            return false;
        else {
            data.remove(index - 1); /* remove "----------" in line above */
            index--;
            while(index <= data.size() - 1 && (!data.get(index).equals("----------"))) {
                data.remove(index);
            }
            data_file.setText(data.toArray(new String[data.size()]));
            data_file.appendText("\n----------\n" + remove.toString());
            return true;
        }
    }
    /* finds batch in data file and replaces it with updated batch */
    public boolean replaceBatch(FileBatch old, FileBatch updated) {
        TextFile data_file = new TextFile(file_name);
        /* read in data file and split into an array of lines */
        ArrayList<String> data = data_file.getLines();
        System.out.println("\nStarting data: \n" + data.toString());
        int old_index = data.indexOf(old.getName());
        if(old_index <= 0) /* old filebatch not found in data file */
            return false;
        else {
            data.remove(old_index - 1); /* remove "----------" in line above */
            System.out.println("\nRemoved line break:\n" + data.toString());
            old_index--;
            while(old_index <= data.size() - 1 && (!data.get(old_index).equals("----------"))) {
                data.remove(old_index);
                System.out.println("\nRemoved line:\n" + data.toString());
            }
            System.out.println("\nFinal file before addition:\n");
            for(int i = 0; i < data.size() - 1; i++) // todo: testing. Why are linebreaks lost without this?
                data.set(i, data.get(i) + "\n");
            data_file.setText(data.toArray(new String[data.size()]));
            data_file.appendText("\n----------\n" + updated.toString());
            return true;
        }
    }
    /* creates file with blank values */
    public void setDefaultSettings() {
        try {
            FileWriter file = new FileWriter(file_name);
            BufferedWriter write_settings = new BufferedWriter(file);
            write_settings.write("Stored Batches:");
            write_settings.close();
        } catch (IOException e) {
            System.out.println(messages.error_writing_default_settings());
        }
    }
    /* returns arraylist containing names of all stored batches */
    public ArrayList<String> getSavedBatches() {
        TextFile data_file = new TextFile(file_name);
        ArrayList<String> data = data_file.getLines();
        ArrayList<String> batch_names = new ArrayList<>();
        int index = data.indexOf("----------");
        while(index > -1) {
            batch_names.add(data.get(index + 1));
            data.remove(index); /* remove separator */
            index = data.indexOf("----------");
        }
        /*ArrayList<String> batch_names = new ArrayList<>();
        try {
            FileReader file = new FileReader(file_name);
            BufferedReader read_settings = new BufferedReader(file);
            String line;
            int line_counter = 0;
            while((line = read_settings.readLine()) != null) {
                if (line.equals("----------")) { /* signifies new batch */
        /*            line_counter = 0;
                }
                if(line_counter == 1) /* name of batch */
        /*            batch_names.add(line);
                line_counter++;
            }
        } catch (IOException e) {
            setDefaultSettings();
        } */
        return batch_names;
    }
    /* returns whether specified batch exists */
    public boolean batchExists(String batch_name) {
        return
            getSavedBatches().contains(batch_name);
    }
    /* returns filebatch of specified name from storage */
    public FileBatch getBatch(String batch_name) throws NoSuchElementException {
        TextFile data_file = new TextFile(file_name);
        ArrayList<String> data = data_file.getLines();
        int index = data.indexOf(batch_name);
        if(index < 0) { /* specified batch not found */
            throw new NoSuchElementException("The batch \"" + batch_name + "\" could not be found");
        } else {
            String constructor = data.get(index);
            index++;
            while(index <= data.size() - 1 && (!data.get(index).equals("----------"))) {
                constructor += "\n" + data.get(index);
                index++;
            }
            System.out.println("Constructor is :\n" + constructor);
            FileBatch constructed_batch = new FileBatch();
            constructed_batch.constructBatch(constructor);
            return constructed_batch;
        }
        /*try {
            FileReader file = new FileReader(file_name);
            BufferedReader read_settings = new BufferedReader(file);
            String line;
            String constructor = "";
            FileBatch batch = new FileBatch();
            boolean batch_found = false;
            int line_counter = 0;
            while((line = read_settings.readLine()) != null) { // todo: far from perfect
                if (line.equals("----------")) { /* signifies new batch */
        /*            line_counter = 0;
                }
                if (line_counter == 1) {
                    if (line.equals(batch_name))
                        batch_found = true;
                    else
                        batch_found = false;
                }
                if (batch_found)
                    constructor += line;
                line_counter++;
            }
            System.out.println(batch.constructBatch(constructor));
            return batch;
        } catch (IOException e) {
            setDefaultSettings();
            return new FileBatch();
        } */
    }
}


