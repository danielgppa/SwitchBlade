import IOCard from "../components/IOCard"
import { whatIsThePercentageOf, valueIsWhatPercentageOf, percentageDecrease, percentageIncrease,
         increaseByPercentage, decreaseByPercentage, initialIncreasedByPercentage, initialDecreasedByPercentage } from "../api/calc/apiFetchPercentage"

function Calculators() {

    return (
        <div>
            <h1>Percentage Calculators</h1>
            <IOCard name='Percentage of value' calculationFunction={whatIsThePercentageOf} displayText = {"|% of|is?"}></IOCard>
            <IOCard name='Value is percentage of' calculationFunction={valueIsWhatPercentageOf} displayText = {"The value|is what percentage of|?"}></IOCard>
            <IOCard name='Percentage increase' calculationFunction={percentageIncrease} displayText = {"The value|increased to| What is the percentage increase?"}></IOCard>
            <IOCard name='Percentage decrease' calculationFunction={percentageDecrease} displayText = {"The value|decreased to| What is the percentage decrease?"}></IOCard>
            <IOCard name='Increase by percentage' calculationFunction={increaseByPercentage} displayText = {"The value|increased by|% is"}></IOCard>
            <IOCard name='Decrease by percentage' calculationFunction={decreaseByPercentage} displayText = {"The value|decreased by|% is"}></IOCard>
            <IOCard name='Value increased by percentage' calculationFunction={initialIncreasedByPercentage} displayText = {"A value increased by|% became|. What was the initial value?"}></IOCard>
            <IOCard name='Value decreased by percentage' calculationFunction={initialDecreasedByPercentage} displayText = {"A value decreased by|% became|. What was the initial value?"}></IOCard>
        </div>
    )
}

export default Calculators