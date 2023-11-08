package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import constant.GameValues;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;

public class Seller {

    public int sellLottoTicket(int money) {
        return money / GameValues.MONEY_UNIT.getValue();
    }

    public List<Lotto> issueLotto(int ticketCount) {
        return IntStream.rangeClosed(1, ticketCount).mapToObj(i -> new Lotto(generateLottoNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateLottoNumbers() {
        return new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        GameValues.MIN_LOTTO_NUM.getValue(),
                        GameValues.MAX_LOTTO_NUM.getValue(),
                        GameValues.LOTTO_WINNING_NUM_SIZE.getValue()
                )
        );
    }

}
