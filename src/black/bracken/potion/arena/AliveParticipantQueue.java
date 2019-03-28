package black.bracken.potion.arena;

import black.bracken.potion.creature.Creature;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author BlackBracken
 */
public class AliveParticipantQueue {

    // composited
    private final Queue<Creature> participantQueue;

    public AliveParticipantQueue(Creature... participants) {
        this.participantQueue = Arrays.stream(participants)
                .filter(Creature::isAlive)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    public boolean hasTwoOrMoreParticipants() {
        int remainParticipants = (int) this.participantQueue
                .parallelStream()
                .filter(Creature::isAlive)
                .count();

        return 2 <= remainParticipants;
    }

    public Creature pop() {
        return participantQueue.remove();
    }

    public Optional<Creature> peekSafety() {
        return Optional.ofNullable(participantQueue.peek());
    }

    public void pushIfAlive(Creature creature) {
        if (creature.isAlive()) {
            participantQueue.add(creature);
        }
    }

}
