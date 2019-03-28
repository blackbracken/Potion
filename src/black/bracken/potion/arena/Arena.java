package black.bracken.potion.arena;

import black.bracken.potion.creature.Creature;

/**
 * @author BlackBracken
 */
public final class Arena {

    private final AliveParticipantQueue participantQueue;

    private boolean isHeld;
    private boolean isEnded;

    public Arena(Creature... participants) {
        this.participantQueue = new AliveParticipantQueue(participants);
    }

    // TODO: consider to need
    public void hold() {
        if (this.isHeld) return;
        this.isHeld = true;

        proceed();
    }

    private void end() {
        this.isEnded = true;
    }

    public void proceed() {
        if (this.isEnded) throw new IllegalStateException("This arena has already ended!");
        if (!this.isHeld) this.isHeld = true;

        var canContinue = participantQueue.hasTwoOrMoreParticipants();
        if (!canContinue) {
            end();
        } else {
            var attacker = participantQueue.pop();
            var victim = participantQueue.pop();

            attacker.attack(victim);

            participantQueue.pushIfAlive(victim);
            participantQueue.pushIfAlive(attacker);
        }
    }

    public ArenaProgress getProgress() {
        if (!this.isHeld) {
            return ArenaProgress.Preparing.getInstance();
        }

        if (this.isEnded) {
            return new ArenaProgress.Finished(participantQueue.peekSafety().orElse(null));
        }

        return ArenaProgress.Running.getInstance();
    }

}
