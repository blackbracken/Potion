
package black.bracken.potion.arena;

import black.bracken.potion.creature.Creature;

import java.util.Optional;

/**
 * @author BlackBracken
 * TODO: KotlinやScalaなら直和型(sealed/case class)を使うべき
 */
public interface ArenaProgress {

    final class Preparing implements ArenaProgress {

        private static Preparing instance;

        static {
            instance = new Preparing();
        }

        static Preparing getInstance() {
            return instance;
        }

        private Preparing() {
            if (instance != null) throw new IllegalStateException("The instance has been already initialized!");
        }

    }

    final class Running implements ArenaProgress {

        private static Running instance;

        static {
            instance = new Running();
        }

        static Running getInstance() {
            return instance;
        }

        private Running() {
            if (instance != null) throw new IllegalStateException("The instance has been already initialized!");
        }

    }

    final class Finished implements ArenaProgress {

        private Creature nullableChampion;

        public Finished() {
            this.nullableChampion = null;

        }

        public Finished(Creature champion) {
            this.nullableChampion = champion;
        }

        public Optional<Creature> getChampion() {
            return Optional.ofNullable(this.nullableChampion);
        }

    }

}
