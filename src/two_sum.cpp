#include<unordered_map>
#include<vector>
#include<iostream>

//ONE LOOP, RETURNS VECTOR{-1,-1} IF NOT FOUND
//CASTS NEEDED FOR STANDARD COMPLIANCE
//O(n) RUNTIME AND SPACE
class Solution{
  public:
    std::vector<int> twoSum(std::vector<int>& numbers, int target){
      std::unordered_map<int, int> hash_map{};
      for(std::size_t i=0; i<numbers.size(); ++i){
        auto found_i = hash_map.find(target-numbers[i]);
        if(found_i != hash_map.end())
          return std::vector<int>{found_i->second, static_cast<int>(i)};
        hash_map.emplace(std::make_pair(numbers[i], i));
      }
      return std::vector<int>{-1,-1};
    }
};

int main(){
  auto temp = Solution{};
  auto test_case = std::vector<int>{3,2,4};
  auto result = temp.twoSum(test_case, 6);
  std::cout << result[0] << " " << result[1] << std::endl;

  return 0;

}
