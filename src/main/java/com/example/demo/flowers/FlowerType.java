package com.example.demo.flowers;


public enum FlowerType {
    CHAMOMILE, ROSE, TULIP;

    public String toString() {
        switch (this) {
            case ROSE :
                return "Rose";
            case CHAMOMILE :
                return "Chamomile";
            default :
                return "Tulip";
        }
    }
}
