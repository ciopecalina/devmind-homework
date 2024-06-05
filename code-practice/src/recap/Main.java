package recap;

import java.lang.reflect.Modifier;
import java.util.*;

class Abilities implements Comparable<Abilities> {
    private double stamina;
    private double speed;
    private int agility;

    public Abilities(double stamina, double speed, int agility) {
        this.stamina = stamina;
        this.speed = speed;
        this.agility = agility;
    }

    @Override
    public int compareTo(Abilities other) {
        if (this.stamina < other.stamina) {
            return -1;
        }

        if (this.stamina > other.stamina) {
            return 1;
        }

        if (this.speed < other.speed) {
            return -1;
        }

        if (this.speed > other.speed) {
            return 1;
        }

        if (this.agility < other.agility) {
            return -1;
        }

        if (this.agility > other.agility) {
            return 1;
        }

        return 0;
    }

    public void update(double stamina, double speed, int agility) {
        this.stamina += stamina;
        this.speed += speed;
        this.agility += agility;
    }

    public int powerDifferenceApprox(Abilities other) {
        return (int) Math.abs(other.stamina - this.stamina);
    }

    @Override
    public String toString() {
        return "Player has a power of: " + this.stamina
                + ", the speed: " + this.speed
                + " and the agility: " + this.agility;
    }
}

abstract class Creature implements ICreature, Comparable<Creature> {
    private Abilities abilities;
    private String nickname;
    private long score;

    public Creature(double stamina, double speed, int agility,
                    String nickname, long score) {
        this.abilities = new Abilities(stamina, speed, agility);
        this.nickname = nickname;
        this.score = score;
    }

    @Override
    public void updateScore(long amount) throws NumberFormatException {
        if (amount < 0) {
            throw new NumberFormatException(
                    "Expecting positive bonus value, got: " + amount);
        } else {
            this.score += amount;
        }
    }

    @Override
    public void powerUp(double stamina, double speed, int agility) {
        this.abilities.update(stamina, speed, agility);
    }

    @Override
    public String getNickname() {
        return this.nickname;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public int compareTo(Creature other) {
        return this.abilities.compareTo(other.abilities);
    }

    @Override
    public String toString() {
        return "Nickname: " + this.nickname
                + "\nScore: " + this.score
                + "\nAbilities: " + this.abilities;
    }

}

class Dragon extends Creature implements IBurn {
    private double flamesPower;
    private int flySpeed;

    public Dragon(double stamina, double speed, int agility, String nickname, long score, double flamesPower, int flySpeed) {
        super(stamina, speed, agility, nickname, score);
        this.flamesPower = flamesPower;
        this.flySpeed = flySpeed;
    }

    @Override
    public double getFlamesPower() {
        return this.flamesPower;
    }

    @Override
    public int getFlyingSpeed() {
        return this.flySpeed;
    }

    @Override
    public void powerUp(double newStamina, double newSpeed, int newAgility) {
        super.powerUp(2 * newStamina, newSpeed / 2, 3 * newAgility);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nFlames power: " + this.flamesPower
                + "\nFly speed: " + this.flySpeed;
    }

}


interface IBite {
    double getBitePower();
}

interface IBurn {
    double getFlamesPower();

    int getFlyingSpeed();
}

interface ICreature {
    String getNickname();

    void setNickname(String nickname);

    void updateScore(long amount) throws NumberFormatException;

    void powerUp(double stamina, double speed, int agility);
}

class Cohort<C extends Creature> {
    Map<String, C> citizens = new HashMap<>();

    public int size() {
        return citizens.size();
    }

    public C getCitizenAt(String address) {
        return citizens.get(address);
    }

    public boolean isEmpty() {
        return citizens.isEmpty();
    }

    public void addNewCitizen(String address, C creature) {
        citizens.put(address, creature);
    }

    public ArrayList getAllCitizensToFight() {
        ArrayList<C> citizensToFight = new ArrayList<>(citizens.values());
        Collections.sort(citizensToFight);

        return citizensToFight;
    }

    @Override
    public String toString() {
        ArrayList<C> citizensToPrint = getAllCitizensToFight();
        String result = "";
        for (C citizen : citizensToPrint) {
            result += citizen;
        }
        return result;
    }
}

class LordOfJava {
    private Parameters parameters;
    private Cohort<Dragon> dragons;
    private Cohort<Warg> wargs;
    private Cohort<Mumakil> mumakils;

    public LordOfJava(String OS, String gamePATH, String credentials, int noLives) {
        this.parameters = new Parameters(OS, gamePATH, credentials, noLives);
    }

    public void addCreature(Creature creature, String address) throws IllegalArgumentException {
        if (creature instanceof Dragon) {
            dragons.addNewCitizen(address, (Dragon) creature);
        } else if (creature instanceof Warg) {
            wargs.addNewCitizen(address, (Warg) creature);
        } else if (creature instanceof Mumakil) {
            mumakils.addNewCitizen(address, (Mumakil) creature);
        } else {
            throw new IllegalArgumentException("Creature type unknown: " + creature.getClass().getName());
        }
    }

    public int battleDragonsWargs() {
        ArrayList<Dragon> dragonsToFight = dragons.getAllCitizensToFight();
        ArrayList<Warg> wargsToFight = wargs.getAllCitizensToFight();
        if (dragonsToFight.size() > wargsToFight.size()) {
            return 1;
        }

        if (dragonsToFight.size() < wargsToFight.size()) {
            return -1;
        }

        int result = 0;
        for (int i = 0; i < dragonsToFight.size(); i++) {
            int currentResult = dragonsToFight.get(i).compareTo(wargsToFight.get(i));
            if (currentResult == 1) {
                result += 1;
            } else {
                result -= 1;
            }
        }
        return result;
    }

}

class Mumakil extends Creature {

    public Mumakil(double stamina, double speed, int agility, String nickname, long score) {
        super(stamina, speed, agility, nickname, score);
    }

    @Override
    public void powerUp(double newStamina, double newSpeed, int newAgility) {
        super.powerUp(newStamina * 0.75, newSpeed + 10, newAgility);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nA creature of type Mumakil.";
    }

}

class Parameters {
    private String OS;
    private String gamePATH;
    private String credentials;
    private int noLives;

    public Parameters(String OS, String gamePATH, String credentials, int noLives) {
        this.OS = OS;
        this.gamePATH = gamePATH;
        this.credentials = credentials;
        this.noLives = noLives;
    }

    @Override
    public String toString() {
        return "OS: " + this.OS
                + "\nGame Path: " + this.gamePATH
                + "\nCredentials: " + this.credentials
                + "\nNo. lives remaining: " + this.noLives;
    }
}


class Warg extends Creature implements IBite {
    private double bitePower;

    public Warg(double stamina, double speed, int agility, String nickname, long score,
                double bitePower) {
        super(stamina, speed, agility, nickname, score);
        this.bitePower = bitePower;
    }

    @Override
    public double getBitePower() {
        return this.bitePower;
    }

    @Override
    public void powerUp(double newStamina, double newSpeed, int newAgility) {
        super.powerUp(newStamina / 2, newSpeed * 4, newAgility);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nBite Power: " + this.bitePower;
    }

}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testId = scanner.nextInt();
        switch (testId) {
            case 0:
                System.out.println("Ok! Let's start!");
                break;
            case 1:
                Parameters parameters = new Parameters("Mac OS", "./username", "strongPassword2021", 100);
                System.out.println(parameters);
            case 2:
                Abilities ability1 = new Abilities(25.0, 100.0, 14);
                Abilities ability2 = new Abilities(25.0, 98.0, 14);
                Abilities ability3 = new Abilities(25.0, 98.0, 27);

                System.out.println(ability1.compareTo(ability2));
                System.out.println(ability2.compareTo(ability3));

                System.out.println(ability1.powerDifferenceApprox(ability2));
                ability1.update(30, 17, -10);
                System.out.println(ability1.powerDifferenceApprox(ability2));
                break;
            case 3:
                Class<Creature> creature = Creature.class;
                System.out.println(Modifier.isAbstract(creature.getModifiers()));
                System.out.println(ICreature.class.isAssignableFrom(creature));
                System.out.println(Comparable.class.isAssignableFrom(creature));
                break;
            case 4:
                Class<Dragon> dragonClass = Dragon.class;
                Dragon dragon1 = new Dragon(25, 100, 15, "master_dragon", 80, 20, 40);
                System.out.println(IBurn.class.isAssignableFrom(dragonClass));
                dragon1.powerUp(10, 20, 12);
                System.out.println(dragon1);
                break;
            case 5:
                Class<Warg> wargClass = Warg.class;
                Warg warg1 = new Warg(25, 100, 15, "master_warg", 85, 20);
                System.out.println(IBite.class.isAssignableFrom(wargClass));
                warg1.powerUp(10, 20, 12);
                System.out.println(warg1);
                break;
            case 6:
                Mumakil mumakil1 = new Mumakil(25, 100, 15, "master_muma", 60);
                mumakil1.powerUp(10, 20, 12);
                System.out.println(mumakil1);
                break;
            case 7:
                Cohort<Dragon> dragonCohort = new Cohort<>();
                Dragon dragon71 = new Dragon(25, 100, 15, "master_dragon1", 80, 20, 40);
                Dragon dragon72 = new Dragon(35, 76, 5, "master_dragon2", 100, 20, 40);

                System.out.println(dragonCohort.isEmpty());
                dragonCohort.addNewCitizen("25,25", dragon71);
                dragonCohort.addNewCitizen("10,12", dragon72);
                System.out.println(dragonCohort.isEmpty());

                System.out.println(dragonCohort.getCitizenAt("25,25"));
                System.out.println(dragonCohort.getAllCitizensToFight());
                System.out.println(dragonCohort.getCitizenAt("test"));
                break;
            case 8:
                LordOfJava lordOfJava = new LordOfJava("Mac OS", "./username", "strongPassword2021", 3);

                Dragon dragon81 = new Dragon(25, 100, 15, "master_dragon1", 80, 20, 40);
                Dragon dragon82 = new Dragon(35, 76, 5, "master_dragon2", 100, 20, 40);

                Warg warg81 = new Warg(25, 100, 15, "master_warg1", 85, 20);
                Warg warg82 = new Warg(80, 56, 23, "master_warg1", 85, 20);

                Mumakil mumakil81 = new Mumakil(25, 100, 15, "master_muma", 60);

                lordOfJava.addCreature(dragon81, "25,25");
                lordOfJava.addCreature(dragon82, "14,24");
                lordOfJava.addCreature(warg81, "12,27");
                lordOfJava.addCreature(warg82, "05,15");
                lordOfJava.addCreature(mumakil81, "01,01");

                System.out.println(lordOfJava.battleDragonsWargs());
                System.out.println(lordOfJava);
            case 9:
                Cohort<Mumakil> mCohort = new Cohort<>();
                System.out.println(mCohort.isEmpty());
                mCohort.addNewCitizen("address1", new Mumakil(300, 100, 100, "Mumakil1", 10000));
                System.out.println(mCohort.isEmpty());
                mCohort.addNewCitizen("address2", new Mumakil(200, 100, 100, "Mumakil2", 10000));
                System.out.println(mCohort.size());
                System.out.println(mCohort.getCitizenAt("address2"));
                System.out.println();
                System.out.println(mCohort.toString());
                break;
            case 10:
                lordOfJava = new LordOfJava("Windows", "Users/Games", "credentials.txt", 2);
                lordOfJava.addCreature(new Mumakil(200, 100, 100, "Mumakil2", 10000), "address1");
                lordOfJava.addCreature(new Dragon(300, 100, 100, "Dragon1", 10000, 23.4, 300), "address2");
                lordOfJava.addCreature(
                        new Warg(9500, 400, 3000, "Castwargarozas", 2880, 88400), "address3");
                System.out.println(lordOfJava.battleDragonsWargs());
                lordOfJava.addCreature(
                        new Dragon(300, 100, 100, "Dragonnnnnn", 10000, 23.4, 300), "address4");
                lordOfJava.addCreature(new Warg(9500, 400, 3000, "Catz", 2880, 88400), "address5");
                System.out.println(lordOfJava.battleDragonsWargs());
                System.out.println(lordOfJava.toString());
                break;
            default:
                System.out.println("Invalid test number!");
                break;
        }
    }
}
