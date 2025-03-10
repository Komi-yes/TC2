public class Fleet {

    private Board board;
    private ArrayList<Machine> machines;
    private int name;

    public void moveNorth(){
        for(Machine m : machines){
            if(m.getLocation.getLatitude < 90){
                m.moveNorth();
            }
        }
    }

    public void advance(int dLon, int dLat){
        for (Machine m : machines){
            m.advance(dLon, dLat);
        }
    } 
    
    public ArrayList<Machine> willBeDestroyed(int longitude, int latitude){
        ArrayList<Machine> machinesAffected = new ArrayList<>();
        for (Machine machine : machines){
            if(machine.isItHit(longitude,latitude)){
                machinesAffected.add(machine);
            }
        }
        return machinesAffected;
    }

    public ArrayList<Machine> weakMachines(){
        ArrayList<Machine> weakMachines = new ArrayList<>();
        for(Machine machine : machines){
            if(machine.isWeak()){
                weakMachines.add(machine);
            }
        }
        return weakMachines;
    }
    
    public boolean isGoodAttack(int longitude, int latitude){
        for (Fleet fleet : board.getFleet()){
            if (this != fleet){
                for (Machine machine: fleet.getMachines()){
                    if (machine.isItHit(longitude,latitude)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void attack(int lon, int lat){
        ArrayList<Machine> arrived = new ArrayList<>();
        ArrayList<Machine> strongMachines = strongMachines()
        while(arrived.size() != strongMachines.size()){
            for(Machine machine : strongMachines){
                if (!machine.isInLoc(lon,lat)){
                    machine.attack();
                }
                else{
                    arrived.add(machine);
                }

            }
        }
    }
}