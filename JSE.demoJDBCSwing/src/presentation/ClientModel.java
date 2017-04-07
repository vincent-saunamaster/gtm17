package presentation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import metier.Client;

public class ClientModel extends AbstractTableModel {

	// colonnes de la table
	private String[] tableColumnNames = new String[] { "ID", "NOM", "PRENOM", "COULEUR_YEUX" };
	// lignes de la table (Vector sont des listes)
	private Vector<String[]> tableValues = new Vector<String[]>();

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return tableColumnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return tableValues.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return tableValues.get(rowIndex)[columnIndex];
	}

	// retourne le nom de la colonne
	// nom de la m�thode  impos�s !!!!!!!!!!!!!!!!!!!!
	public String getColumnName(int column) {
		return tableColumnNames[column];
	}

	// pour remplir le tableau avec les donn�es de BDD
	// nom de la m�thode  impos�s !!!!!!!!!!!!!!!!!!!!
	public void setData(List<Client> clients) {
		// initialise le tableau � afficher
		tableValues = new Vector<String[]>();
		// remplit le tableau � afficher
		for (Client c : clients) {
			tableValues.add(new String[] { String.valueOf(c.getId()), c.getNom(), c.getPrenom(), c.getCouleurYeux() });
		}
		// �coute et change le tableau quand c'est demand�
		fireTableChanged(null);
	}

}
