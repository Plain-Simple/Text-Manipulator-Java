/* Plain+Simple TextManipulator GUI */
import javax.swing.JFrame;
import java.util.Arrays;
import java.lang.Character;
import java.io.*;
import java.util.Vector;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import textfunctions.ManipulateText;
import textfunctions.AnalyzeText;

public class GUI extends JFrame {
	/* Plain+Simple TextManipulator GUI version */

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        sortLines_buttongroup = new javax.swing.ButtonGroup();
        list_title = new javax.swing.JLabel();
        analyzetext_button = new javax.swing.JButton();
        wordcount_label = new javax.swing.JLabel();
        charcount_label = new javax.swing.JLabel();
        linecount_label = new javax.swing.JLabel();
        sentencecount_label = new javax.swing.JLabel();
        text_field = new javax.swing.JScrollPane();
        text_input = new javax.swing.JTextArea();
        sortLines_button = new javax.swing.JButton();
        removepunctuation_button = new javax.swing.JButton();
        cleartext_box = new javax.swing.JButton();
        error_message = new javax.swing.JLabel();
        copy_button = new javax.swing.JButton();
        loadfile_button = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        filename_label = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        removeDuplicateLines_button = new javax.swing.JButton();
        forceUppercase_button = new javax.swing.JButton();
        forceLowercase_button = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        sortAlphabetically_radiobutton = new javax.swing.JRadioButton();
        sortBySize_radiobutton = new javax.swing.JRadioButton();
        sortRandomly_radiobutton = new javax.swing.JRadioButton();
        addPrefix_button = new javax.swing.JButton();
        prefix_textfield = new javax.swing.JTextField();
        addSuffix_button = new javax.swing.JButton();
        suffix_textfield = new javax.swing.JTextField();
        removeEmptyLines_button = new javax.swing.JButton();
        commaSeparate_button = new javax.swing.JButton();
        lineSeparate_button = new javax.swing.JButton();
        remove_button = new javax.swing.JButton();
        remove_textfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plain+Simple TextManipulator");
        setBackground(new java.awt.Color(255, 255, 255));

        list_title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        list_title.setText("Available Functions");

        analyzetext_button.setText("Analyze Text");
        analyzetext_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzetext_buttonActionPerformed(evt);
            }
        });

        text_input.setColumns(20);
        text_input.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        text_input.setRows(5);
        text_input.setText("[Enter text here]");
        text_field.setViewportView(text_input);

        sortLines_button.setText("Sort Lines");
        sortLines_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortLines_buttonActionPerformed(evt);
            }
        });

        removepunctuation_button.setText("Remove Punctuation");
        removepunctuation_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removepunctuation_buttonActionPerformed(evt);
            }
        });

        cleartext_box.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cleartext_box.setText("Clear Text");
        cleartext_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleartext_boxActionPerformed(evt);
            }
        });

        error_message.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        error_message.setForeground(new java.awt.Color(204, 0, 0));

        copy_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        copy_button.setText("Copy to Clipboard");
        copy_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copy_buttonActionPerformed(evt);
            }
        });

        loadfile_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loadfile_button.setText("Load File");
        loadfile_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadfile_buttonActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        title.setText("TextManipulator v 0.2");

        filename_label.setText("[Enter file name]");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        removeDuplicateLines_button.setText("Remove Duplicate Lines");
        removeDuplicateLines_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDuplicateLines_buttonActionPerformed(evt);
            }
        });

        forceUppercase_button.setText("Force Upper Case");
        forceUppercase_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forceUppercase_buttonActionPerformed(evt);
            }
        });

        forceLowercase_button.setText("Force Lower Case");
        forceLowercase_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forceLowercase_buttonActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        sortLines_buttongroup.add(sortAlphabetically_radiobutton);
        sortAlphabetically_radiobutton.setText("Alphabetically");
        sortAlphabetically_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortAlphabetically_radiobuttonActionPerformed(evt);
            }
        });

        sortLines_buttongroup.add(sortBySize_radiobutton);
        sortBySize_radiobutton.setText("By Size");
        sortBySize_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortBySize_radiobuttonActionPerformed(evt);
            }
        });

        sortLines_buttongroup.add(sortRandomly_radiobutton);
        sortRandomly_radiobutton.setText("Randomly (Scramble)");
        sortRandomly_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortRandomly_radiobuttonActionPerformed(evt);
            }
        });

        addPrefix_button.setText("Add Prefix");
        addPrefix_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPrefix_buttonActionPerformed(evt);
            }
        });

        addSuffix_button.setText("Add Suffix");
        addSuffix_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSuffix_buttonActionPerformed(evt);
            }
        });

        removeEmptyLines_button.setText("Remove Empty Lines");
        removeEmptyLines_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmptyLines_buttonActionPerformed(evt);
            }
        });

        commaSeparate_button.setText("Comma-Separate Values");
        commaSeparate_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commaSeparate_buttonActionPerformed(evt);
            }
        });

        lineSeparate_button.setText("Line-Separate Values");
        lineSeparate_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineSeparate_buttonActionPerformed(evt);
            }
        });

        remove_button.setText("Remove");
        remove_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(list_title, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(error_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(wordcount_label, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(linecount_label)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(sentencecount_label)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charcount_label))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(loadfile_button)
                                                                .addGap(2, 2, 2)
                                                                .addComponent(filename_label, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(copy_button)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cleartext_box, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(text_field, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(analyzetext_button, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(removepunctuation_button)
                                                                        .addComponent(removeDuplicateLines_button)
                                                                        .addComponent(forceUppercase_button)
                                                                        .addComponent(forceLowercase_button))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(commaSeparate_button)
                                                                                .addComponent(removeEmptyLines_button, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                        .addComponent(lineSeparate_button))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(sortLines_button)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(sortAlphabetically_radiobutton))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(addPrefix_button)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(prefix_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(sortBySize_radiobutton)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(sortRandomly_radiobutton))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(addSuffix_button)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(suffix_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(remove_button)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(remove_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {charcount_label, linecount_label, sentencecount_label, wordcount_label});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addPrefix_button, addSuffix_button, analyzetext_button, commaSeparate_button, forceLowercase_button, forceUppercase_button, lineSeparate_button, loadfile_button, removeDuplicateLines_button, removeEmptyLines_button, remove_button, removepunctuation_button, sortLines_button});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {prefix_textfield, remove_textfield});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(text_field, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(copy_button)
                                        .addComponent(cleartext_box)
                                        .addComponent(loadfile_button)
                                        .addComponent(filename_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(list_title, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                        .addComponent(error_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(analyzetext_button)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(removepunctuation_button)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(removeDuplicateLines_button)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(forceUppercase_button)
                                                .addGap(5, 5, 5)
                                                .addComponent(forceLowercase_button)
                                                .addGap(25, 25, 25))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(sortLines_button)
                                                                        .addComponent(sortAlphabetically_radiobutton)
                                                                        .addComponent(sortBySize_radiobutton)
                                                                        .addComponent(sortRandomly_radiobutton))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(addPrefix_button)
                                                                        .addComponent(prefix_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(addSuffix_button)
                                                                        .addComponent(suffix_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(remove_button)
                                                                        .addComponent(remove_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(removeEmptyLines_button)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(commaSeparate_button)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lineSeparate_button)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(charcount_label)
                                        .addComponent(wordcount_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(linecount_label)
                                                .addComponent(sentencecount_label)))
                                .addGap(31, 31, 31))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {charcount_label, linecount_label, sentencecount_label, wordcount_label});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {filename_label, loadfile_button, removeDuplicateLines_button, removepunctuation_button});

        sortLines_button.getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>                        

    private void analyzetext_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String text = GetText();
        int word_count = AnalyzeText.WordCount(text);
        wordcount_label.setText(word_count + ((word_count == 1) ? " word" : " words"));
        int char_count = AnalyzeText.CharCount(text);
        charcount_label.setText(char_count + ((char_count == 1) ? " character" : " characters"));
        int line_count = AnalyzeText.LineCount(text);
        linecount_label.setText(line_count + ((line_count == 1) ? " line" : " lines"));
        int sentence_count = AnalyzeText.SentenceCount(text);
        if(sentence_count == 0)
            sentence_count++;
        sentencecount_label.setText(sentence_count + ((sentence_count == 1) ? " sentence" : " sentences"));
    }
    /// only works the first time
    private void sortLines_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if(sortAlphabetically_radiobutton.isSelected()) /* need to know which radiobutton is currently pressed */
            SetText(ManipulateText.SortLinesAlphabetically(GetText()));
        else if(sortBySize_radiobutton.isSelected())
            SetText(ManipulateText.SortLinesBySize(GetText()));
        else if(sortRandomly_radiobutton.isSelected())
            SetText(ManipulateText.ScrambleLines(GetText()));
        else
            SetErrorMessage("Error: No button selected");
        //sortLines_buttongroup.clearSelection();
    }

    private void removepunctuation_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        SetText(ManipulateText.RemovePunctuation(GetText()));
    }

    private void cleartext_boxActionPerformed(java.awt.event.ActionEvent evt) {
        ClearText();
    }
    /* copies all text from 'text_input' to system clipboard */
    private void copy_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String text = GetText();
        StringSelection stringSelection = new StringSelection (text); /// I kind of just found this code online, it's not original
        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);
    }

    private void loadfile_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        boolean[] success = new boolean[1];
        String file_name = filename_label.getText();
        String new_text = ReadFromFile(file_name, success);
        if(success[0])  /* file read successfully */
            SetText(new_text);
        else
            SetErrorMessage("Error reading file \"" + file_name + "\"");
    }

    private void removeDuplicateLines_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        SetText(ManipulateText.RemoveDuplicateLines(GetText()));
    }

    private void forceUppercase_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        SetText(ManipulateText.ForceUppercase(GetText()));
    }

    private void forceLowercase_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        SetText(ManipulateText.ForceLowercase(GetText()));
    }

    private void sortAlphabetically_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {                                                               
        /* function only serves as a flag for SortLines */
    }

    private void sortBySize_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        /* function only serves as a flag for SortLines */
    }

    private void sortRandomly_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        /* function only serves as a flag for SortLines */
    }

    private void addPrefix_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String prefix = prefix_textfield.getText();
        if(prefix.equals("")) {
            SetErrorMessage("Error: No prefix specified");
            prefix_textfield.setText("[Enter prefix]");
        } else
            SetText(ManipulateText.AddPrefixSuffix(GetText(), prefix, ""));
    }

    private void addSuffix_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String suffix = suffix_textfield.getText();
        if(suffix.equals("")) {
            SetErrorMessage("Error: No suffix specified");
            suffix_textfield.setText("[Enter suffix]");
        } else
            SetText(ManipulateText.AddPrefixSuffix(GetText(), "", suffix));
    }

    private void removeEmptyLines_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        SetText(ManipulateText.RemoveEmptyLines(GetText()));
    }

    private void commaSeparate_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        SetText(ManipulateText.CommaSeparateValues(GetText()));
    }

    private void lineSeparate_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        SetText(ManipulateText.LineSeparateValues(GetText(), ' '));
    }

    private void remove_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String remove = remove_textfield.getText();
        if(remove.equals("")) {
            SetErrorMessage("Error: No argument specified");
            remove_textfield.setText("[Enter text to remove]");
        } else
            SetText(ManipulateText.RemoveArgument(remove, GetText()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    /* returns text from the 'text_input' box */
    public String GetText() {
        return text_input.getText();
    }
    /* sets the textbox to 'text' */
    public void SetText(String text) {
        text_input.setText(text);
    }
    /* clears the text box */
    public void ClearText() {
        text_input.setText("");
    }
    public void SetErrorMessage(String message) {
        error_message.setText(message);
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
            read_file.close();
        } catch(IOException e) {
            SetErrorMessage("Error reading file \"" + file_name + "\"");
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
    // Variables declaration - do not modify                     
    private javax.swing.JButton addPrefix_button;
    private javax.swing.JButton addSuffix_button;
    private javax.swing.JButton analyzetext_button;
    private javax.swing.JLabel charcount_label;
    private javax.swing.JButton cleartext_box;
    private javax.swing.JButton commaSeparate_button;
    private javax.swing.JButton copy_button;
    private javax.swing.JLabel error_message;
    private javax.swing.JTextField filename_label;
    private javax.swing.JButton forceLowercase_button;
    private javax.swing.JButton forceUppercase_button;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton lineSeparate_button;
    private javax.swing.JLabel linecount_label;
    private javax.swing.JLabel list_title;
    private javax.swing.JButton loadfile_button;
    private javax.swing.JTextField prefix_textfield;
    private javax.swing.JButton removeDuplicateLines_button;
    private javax.swing.JButton removeEmptyLines_button;
    private javax.swing.JButton remove_button;
    private javax.swing.JTextField remove_textfield;
    private javax.swing.JButton removepunctuation_button;
    private javax.swing.JLabel sentencecount_label;
    private javax.swing.JRadioButton sortAlphabetically_radiobutton;
    private javax.swing.JRadioButton sortBySize_radiobutton;
    private javax.swing.JButton sortLines_button;
    private javax.swing.ButtonGroup sortLines_buttongroup;
    private javax.swing.JRadioButton sortRandomly_radiobutton;
    private javax.swing.JTextField suffix_textfield;
    private javax.swing.JScrollPane text_field;
    private javax.swing.JTextArea text_input;
    private javax.swing.JLabel title;
    private javax.swing.JLabel wordcount_label;
    // End of variables declaration                   
}