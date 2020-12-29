package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }

    public void readTalents(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(" ");
                productions.add(new Production(Integer.parseInt(temp[0]), temp[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read production!", e);
        }
    }

    public void calculateVotes(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                addVote(Integer.parseInt(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read production!", e);
        }
    }

    private void addVote(int id) {
        boolean exist = false;
        for (Vote vote : votes) {
            if (vote.getId() == id) {
                exist = true;
                vote.incNum();
            }
        }
        if (!exist) {
            votes.add(new Vote(id, 1));
        }
    }

    public void writeResultToFile(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (Production production : productions) {
                writer.print(production.getId());
                writer.print(" ");
                writer.print(production.getName());
                writer.print(" ");
                Vote vote = findVotesById(production.getId());
                writer.println(vote.getNumber());
            }
            writer.print("Winner: " + findWinner().getName());
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file!", e);
        }
    }

    private Production findWinner() {
        int maxNumber = 0;
        int maxId = 0;
        for (Vote vote : votes) {
            if (maxNumber < vote.getNumber()) {
                maxNumber = vote.getNumber();
                maxId = vote.getId();
            }
        }
        for (Production production : productions) {
            if (production.getId() == maxId) {
                return production;
            }
        }
        return null;
    }

    private Vote findVotesById(int id) {
        for (Vote vote : votes) {
            if (vote.getId() == id) {
                return vote;
            }
        }
        return null;
    }
}
