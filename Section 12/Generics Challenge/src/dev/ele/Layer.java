package dev.ele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Layer<T extends Mappable> {
    private List<T> elements;

    public Layer() {
        elements = new ArrayList<>();
    }

    public Layer(T element) {
        elements = new ArrayList<>();
        elements.add(element);
    }

    public Layer(Collection<T> elements) {
        this.elements = new ArrayList<>();
        if (elements != null && elements.size() > 0) {
            this.elements.addAll(elements);
        }
    }

    public List<T> getElements() {
        // return new ArrayList<>(elements);
        return Collections.unmodifiableList(elements);
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public void addElements(Collection<T> elements) {
        if (elements != null && elements.size() > 0) {
            this.elements.addAll(elements);
        }
    }

    public void renderLayer() {
        for (T e : elements) {
            e.render();
            System.out.println();
        }
    }
}