package Project_Euler_Solutions_in_Java._32_63._054;

public class PokerCard implements Comparable {
    private Integer cardValue;
    private _054_PokerHands.suit cardSuit;
    String rawSuit;

    PokerCard(String card) {
        parseCard(card);
    }

    int getCardValue() {
        return cardValue;
    }

    _054_PokerHands.suit getCardSuit() {
        return cardSuit;
    }

    private void parseCard(String card) {
        parseValue(card.substring(0, 1));
        parseSuit(card.substring(1));
    }

    private void parseValue(String value) {
        switch (value) {
            case "T": {
                cardValue = 10;
                break;
            }
            case "J": {
                cardValue = 11;
                break;
            }
            case "Q": {
                cardValue = 12;
                break;
            }
            case "K": {
                cardValue = 13;
                break;
            }
            case "A": {
                cardValue = 14;
                break;
            }
            default: {
                cardValue = Integer.parseInt(value);
            }
        }
    }

    private void parseSuit(String suit) {
        this.rawSuit = suit;
        switch (suit) {
            case "H": {
                cardSuit = _054_PokerHands.suit.hearts;
                break;
            }
            case "S": {
                cardSuit = _054_PokerHands.suit.spades;
                break;
            }
            case "C": {
                cardSuit = _054_PokerHands.suit.clubs;
                break;
            }
            case "D": {
                cardSuit = _054_PokerHands.suit.diamonds;
                break;
            }
            default:
                return;
        }
    }

    @Override
    public int compareTo(Object o) {
        PokerCard card = (PokerCard) o;
        return this.cardValue.compareTo(card.cardValue);
    }
}
