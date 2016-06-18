package br.com.nasa.negocio;

import java.util.ArrayList;
import java.util.Collection;

public class ListaCiclica<E> extends ArrayList<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int actualIndex;
	
	public ListaCiclica() {
		super();
	}
	
	public ListaCiclica(final Collection<E> collection) {
        super(collection);
	}
	
	public void setActualIndex(int index) {
		this.actualIndex = index;
	}
	
	@Override
    public E get(int index) {
            index = index % this.size();
            return super.get(index);
    }
	
	public E getActual() {
        return super.get(actualIndex);
	}
	
	public E previous() {
        if (this.actualIndex == 0) {
                this.actualIndex = this.size() - 1;
        } else {
                this.actualIndex--;
        }

        return super.get(actualIndex);
	}
	
	public E next() {
        if (this.actualIndex == this.size() - 1) {
                this.actualIndex = 0;
        } else {
                this.actualIndex++;
        }

        return super.get(actualIndex);
	}
}
