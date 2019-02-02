package Project_Euler_Solutions_in_Java._32_63._054;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class PokerHand implements Comparable {
    private Integer best_hand = new Integer(0);
    private Integer first_combo = new Integer(0);
    private Integer second_combo = new Integer(0);
    private PokerCard high_card;
    private int four_of_a_kind, three_of_a_kind, straight, flush, straight_flush;
    private boolean royal_flush, full_house, two_pair;
    private PokerCard[] cards;

    PokerHand(PokerCard[] cards) {
        Arrays.sort(cards, Collections.reverseOrder());
        this.cards = cards;
        setInitialHighCard();
        calculateBestHand();
    }

    private ArrayList<Integer> getHighCards() {
        ArrayList<Integer> al = new ArrayList<>();
        for (PokerCard c : cards) {
            int cValue = c.getCardValue();
            if (cValue != first_combo && cValue != second_combo) {
                al.add(cValue);
            }
        }
        return al;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PokerCard c : cards) {
            sb.append(c.getCardValue()).append(c.rawSuit).append(" ");
        }
        return sb.toString();
    }

    Integer getBestHand() {
        return this.best_hand;
    }

    private Integer getFirstCombo() {
        return this.first_combo;
    }

    private Integer getSecondCombo() {
        return this.second_combo;
    }

    private void calculateBestHand() {
        int expectedStraightValue = high_card.getCardValue();
        _054_PokerHands.suit s = high_card.getCardSuit();

        boolean r_flush = high_card.getCardValue() == 14;
        boolean flush = true;
        boolean straight = true;

        for (PokerCard c : cards) {

            if (straight) {
                straight = isStillX(c.getCardValue(), expectedStraightValue);
                expectedStraightValue--;
            }
            if (flush) {
                flush = isStillX(s, c.getCardSuit());
            }
            if (r_flush) {
                r_flush = straight && flush;
            }
        }
        royal_flush = r_flush;
        straight_flush = setStreakWithHighestCard(straight && flush);
        this.straight = setStreakWithHighestCard(straight);
        this.flush = setStreakWithHighestCard(flush);
        if (!this.royal_flush &&
                this.straight_flush == 0 &&
                this.straight == 0 &&
                this.flush == 0) {
            findAndSetCombos();
        }
        setBestHand();
    }

    private void findAndSetCombos() {
        int fst_combo_val = 0;
        int snd_combo_val = 0;
        int fst_combo_count = 1;
        int snd_combo_count = 1;
        PokerCard high_card = null;

        for (int fstIndex = 0, sndIndex = fstIndex + 1; sndIndex < cards.length; fstIndex++, sndIndex++) {
            int fstValue = cards[fstIndex].getCardValue();
            int sndValue = cards[sndIndex].getCardValue();
            if (fstValue == sndValue) {
                if (fst_combo_val == 0) {
                    fst_combo_val = fstValue;
                    fst_combo_count++;
                } else if (fst_combo_val == fstValue) {
                    fst_combo_count++;
                } else if (snd_combo_val == 0) {
                    snd_combo_val = sndValue;
                    snd_combo_count++;
                } else if (snd_combo_val == sndValue) {
                    snd_combo_count++;
                }
            } else if (fst_combo_val != fstValue &&
                    snd_combo_val != fstValue &&
                    high_card == null) {
                high_card = cards[fstIndex];

            } else if (fst_combo_val != sndValue &&
                    snd_combo_val != sndValue &&
                    high_card == null) {
                high_card = cards[sndIndex];
            }
        }
        this.high_card = high_card;
        switch (fst_combo_count) {
            case 4: {
                setFourOfAKind(fst_combo_val);
                break;
            }
            case 3: {
                if (snd_combo_count == 2) {
                    setFullHouse(fst_combo_val, snd_combo_val);
                } else {
                    setThreeOfAKind(fst_combo_val);
                }
                break;
            }
            case 2: {
                if (snd_combo_count == 3) {
                    setFullHouse(snd_combo_val, fst_combo_val);
                } else if (snd_combo_count == 2) {
                    setTwoPair(fst_combo_val, snd_combo_val);
                } else setPair(fst_combo_val);
                break;
            }
        }
    }

    private void setBestHand() {
        if (royal_flush) {
            this.best_hand = 10;
        } else if (straight_flush != 0) {
            best_hand = 9;
        } else if (four_of_a_kind != 0) {
            best_hand = 8;
        } else if (full_house) {
            best_hand = 7;
        } else if (flush != 0) {
            best_hand = 6;
        } else if (straight != 0) {
            best_hand = 5;
        } else if (three_of_a_kind != 0) {
            best_hand = 4;
        } else if (two_pair) {
            best_hand = 3;
        } else if (first_combo != 0) {
            best_hand = 2;
        } else {
            best_hand = 1;
        }
    }

    private void setFullHouse(int fst, int snd) {
        this.full_house = true;
        this.first_combo = fst;
        this.second_combo = snd;
    }

    private void setTwoPair(int fst, int snd) {
        this.two_pair = true;
        this.first_combo = fst;
        this.second_combo = snd;
    }

    private void setThreeOfAKind(int val) {
        this.three_of_a_kind = val;
    }

    private void setFourOfAKind(int val) {
        this.four_of_a_kind = val;
    }

    private void setPair(int val) {
        this.first_combo = val;
    }

    private void setInitialHighCard() {
        this.high_card = cards[0];
    }

    private int setStreakWithHighestCard(boolean isX) {
        return isX ? high_card.getCardValue() : 0;
    }

    private boolean isStillX(Comparable s1, Comparable s2) {
        return s1 == s2;
    }

    @Override
    public int compareTo(Object o) {
        PokerHand compareToHand = (PokerHand) o;
        int result = this.best_hand.compareTo(compareToHand.getBestHand());
        if (result == 0) {
            result = this.first_combo.compareTo(compareToHand.getFirstCombo());
            if (result == 0) {
                result = this.second_combo.compareTo(compareToHand.getSecondCombo());
                if (result == 0) {
                    ArrayList<Integer> homeHC = this.getHighCards();
                    ArrayList<Integer> awayHC = compareToHand.getHighCards();
                    for (int index = 0; index < homeHC.size() && result == 0; index++) {
                        result = homeHC.get(index).compareTo(awayHC.get(index));
                    }
                }
            }
        }
        return result;
    }
}