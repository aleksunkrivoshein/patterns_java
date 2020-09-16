package patterns.state;

public class StatePattern {
    public static void main(String[] args) {

        Station fm = new RadioFM();
        Radio radio = new Radio();
        radio.setStation(fm);

        for (int i = 0; i < 10; i++) {
            radio.nextStation();
            radio.play();
        }

    }
}

interface Station {
    void play();
}

class RadioMaria implements Station {
    @Override
    public void play() {
        System.out.println("Radio Maria .... ");
    }
}

class RadioFM implements Station {
    @Override
    public void play() {
        System.out.println("RadioFM .... ");
    }
}

class VestiFM implements Station {
    @Override
    public void play() {
        System.out.println("VestiFM .... ");
    }
}

class Radio {
    private Station station;

    void setStation(Station st) {
        station = st;
    }

    void nextStation() {
        if (station instanceof RadioMaria) {
            setStation(new RadioMaria());
        } else if (station instanceof RadioFM) {
            setStation(new RadioFM());
        } else if (station instanceof VestiFM) {
            setStation(new VestiFM());
        }
    }

    void play() {
        station.play();
    }
}

