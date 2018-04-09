package Hackaton;

import java.util.*;

public class EgorFriends
{
    private static Set<Integer> EgorFriendsSet = new HashSet<>();
    private static Set<Integer> FriendsOfFriendsSet = new HashSet<>();
    private static int friendCount;

    public static void main(String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество друзей Егора: ");
        friendCount = in.nextInt();

        for (int i = 0; i < friendCount; i++) {

            in = new Scanner(System.in);
            System.out.print("Введите параметры " + (i+1) + "-го друга: ");
            String str = in.nextLine();
            List<Integer> friendParam = strToList(str, new ArrayList<Integer>());

            EgorFriendsSet.add(friendParam.get(0));
            for (int j = 2; j < friendParam.size(); j++) FriendsOfFriendsSet.add(friendParam.get(j));
        }
        delEgorsFriendsFromAll(EgorFriendsSet, FriendsOfFriendsSet);
        System.out.println("Количество друзей друзей Егора: " + FriendsOfFriendsSet.size());
    }

    private static List<Integer> strToList(String inputString, List<Integer> friendParam) {
        String[] numbers = inputString.split(" ");
        for (String number : numbers) friendParam.add(Integer.parseInt(number));
        return friendParam;
    }

    private static Set<Integer> delEgorsFriendsFromAll(Set<Integer> EgorFriendsSet, Set<Integer> FriendsOfFriendsSet) {
        FriendsOfFriendsSet.removeAll(EgorFriendsSet);
        return FriendsOfFriendsSet;
    }
}

