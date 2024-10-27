#include <iostream>
#include <vector>
#include <string>
#include <cctype>
#include <algorithm>
#include <random>

int main(int argc, char* argv[]) {
    std::vector<std::string> numbers;
    
    std::vector<std::string>* words = new std::vector<std::string>();

    for (int i = 1; i < argc; ++i) {
        std::string arg(argv[i]);

        if (std::isdigit(arg[0])) {
            numbers.push_back(arg);
        } else {
            words->push_back(arg);
        }
    }

    std::sort(words->begin(), words->end());

    std::random_device rd;
    std::mt19937 g(rd());
    std::shuffle(numbers.begin(), numbers.end(), g);

    std::cout << "Numbers (shuffled):" << std::endl;
    for (const auto& num : numbers) {
        std::cout << num << std::endl;
    }

    std::cout << "Words (sorted):" << std::endl;
    for (const auto& word : *words) {
        std::cout << word << std::endl;
    }

    delete words;

    return 0;
}
