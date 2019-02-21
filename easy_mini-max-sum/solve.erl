-module(solution).
-export([main/0]).



% Complete the miniMaxSum function below.
miniMaxSum(Arr) ->
    Sum = lists:sum(Arr),
    MinSum = Sum - lists:max(Arr),
    MaxSum = Sum - lists:min(Arr),
    io:format("~B ~B", [MinSum, MaxSum]).

read_multiple_lines_as_list_of_strings(N) ->
    read_multiple_lines_as_list_of_strings(N, []).

read_multiple_lines_as_list_of_strings(0, Acc) ->
    lists:reverse(Acc);
read_multiple_lines_as_list_of_strings(N, Acc) when N > 0 ->
    read_multiple_lines_as_list_of_strings(N - 1, [string:chomp(io:get_line("")) | Acc]).

main() ->
    ArrTemp = re:split(string:chomp(io:get_line("")), "\\s+", [{return, list}, trim]),

    Arr = lists:map(fun(X) -> {I, _} = string:to_integer(X), I end, ArrTemp),

    miniMaxSum(Arr),

    ok.

