package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).orElseGet(null);
        Assertions.assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void solution() {
        int answer;
        int check = 0;
        int count = 0;
        int[] lost = {3, 1, 2};
        int[] reserve = {2, 4, 3};
        int n = 4;
        int[] arr = new int[4];


        Arrays.fill(arr, 1);
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < reserve.length; i++) {
            count++;
            arr[reserve[i] - 1] += count;
            count = 0;
        }

        for (int i = 0; i < lost.length; i++) {
            count++;
            arr[lost[i] - 1] -= count;
            count = 0;
        }

        for (int z = 0; z < arr.length - 1; z++) {

            if (z != 0 && arr[z] == 2 && arr[z - 1] == 0) {
                arr[z] -= 1;
                arr[z - 1] += 1;
            } else if (arr[z] == 2 && arr[z + 1] == 0) {
                arr[z] -= 1;
                arr[z + 1] += 1;
            }
        }

        for (int y = 0; y < arr.length; y++) {
            if (arr[y] != 0) {
                check++;
            }
        }

//        return check;

    }

    @Test
    public String solution1() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < participant.length; i++) {
            if (participant[i] != completion[i]) {
                answer = participant[i];
            }

        }
        return answer;
    }
}
