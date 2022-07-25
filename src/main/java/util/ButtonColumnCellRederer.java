package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rafael
 */

// Editar e Excluir tarefas ou projetos
public class ButtonColumnCellRederer extends DefaultTableCellRenderer {
    
    private String buttonType;
    
    // buttonType como String
    public ButtonColumnCellRederer(String buttonType) {
        this.buttonType = buttonType;
    }
    
    // Métodos Getter and Setter para o ButtonType 
    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
    @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column) {
            
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, 
                    value, isSelected, hasFocus, row, column);
            
            //Centralizando o conteúdo do campo na tabela
            label.setHorizontalAlignment(JLabel.CENTER);
            
            //Setando o tipo de Botão/Icone dentro da pasta Resource 
            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png")));
            
            //Retornar o JLabel que renderiza a célula
            return label;
        }
}
