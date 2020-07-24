package com.icicibank.apimgmt.service.impl;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.icicibank.apimgmt.exceptions.InvalidDatePeriod;
import com.icicibank.apimgmt.model.DurationDetails;
import com.icicibank.apimgmt.service.DurationBreakUpService;

@Service
@RequestScope
public class DurationBreakUpServiceImpl implements DurationBreakUpService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${date.format}")
	String dateFormat;

	@Override
	public String getBreakUpDurations(DurationDetails duration) throws JsonProcessingException, InvalidDatePeriod {

		String finalResponse = "";

		// logger.info((dateFormat));
		LocalDate intialDate = LocalDate.parse(duration.getStartDate(), DateTimeFormatter.ofPattern(dateFormat));

		LocalDate endDate = LocalDate.parse(duration.getEndDate(), DateTimeFormatter.ofPattern(dateFormat));

		LocalDate startDate = intialDate;
		//Period period = Period.between(startDate, endDate);

		logger.info("startDate " + startDate + " endDate " + endDate);
		if (startDate.isAfter(endDate)) {

			throw new InvalidDatePeriod("Start Date Should be less than End Date");
		}

		while (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
			
			logger.info("startDate " + startDate + " endDate " + endDate );
			String monthlyString = "";
			if(startDate.getMonthValue()<10){
				
				monthlyString = startDate.getYear() + "_M0" + startDate.getMonthValue();
			}else {
				
				monthlyString = startDate.getYear() + "_M" + startDate.getMonthValue();
			}
			
			finalResponse = finalResponse.concat(monthlyString).concat(",");
	
			int daysOfMonth = 0;
			if (startDate.getMonth().getValue() == Month.FEBRUARY.getValue()
					&& startDate.isLeapYear()) {

				daysOfMonth = startDate.getMonth().maxLength();
			} else if (startDate.getMonth().getValue() == Month.FEBRUARY.getValue()) {

				daysOfMonth = startDate.getMonth().maxLength() - 1;
			} else {
				daysOfMonth = startDate.getMonth().maxLength();
			}
			startDate = LocalDate.of(startDate.getYear(), startDate.getMonth(),
					daysOfMonth);
			

			if (endDate.isBefore(startDate))
				startDate = endDate;
			// durationDetails.setEndDate(startDate.toString());

			/*
			 * monthlyDurations.add(breakUpDetails);
			 * responseModel.getMonthlyBreakUpDetails().setNoOfMonthlyBreakUp(++
			 * monthlyBreakUp);
			 * responseModel.getMonthlyBreakUpDetails().setListOfDurations(monthlyDurations)
			 * ;
			 */
			startDate = startDate.plusDays(1);


			/*
			 * 
			 * logger.info("Period in years "+period.getYears()+" period in months "+period.
			 * getMonths()+" Period in days "+period.getDays());
			 * 
			 * if (period.getYears() >= 1 || period.getMonths()>=11 && period.getDays()>=1)
			 * {
			 * 
			 * if (startDate.getMonth().getValue() == Month.APRIL.getValue()) {
			 * 
			 * logger.info("startDate " + startDate + " endDate " + endDate + " yearly in");
			 * // durationDetails.setStartDate(startDate.toString()); String yearlyStirng =
			 * startDate.getYear() + "_A01";
			 * 
			 * 
			 * startDate = LocalDate.of(startDate.plusYears(1).getYear(), Month.MARCH,
			 * Month.MARCH.maxLength());
			 * 
			 * if (endDate.isBefore(startDate)) startDate = endDate; //
			 * durationDetails.setEndDate(startDate.toString());
			 * 
			 * finalResponse = finalResponse.concat(yearlyStirng).concat(",");
			 * 
			 * 
			 * yearlyDurations.add(breakUpDetails);
			 * responseModel.getYearlyBreakupDetails().setNoOfYearlyBreakUps(++yearlyBreakUp
			 * );
			 * responseModel.getYearlyBreakupDetails().setListOfDurations(yearlyDurations);
			 * 
			 * startDate = startDate.plusDays(1);
			 * 
			 * period = Period.between(startDate, endDate);
			 * 
			 * logger.info("startDate " + startDate + " endDate " + endDate +
			 * " yearly out"); } else if (startDate.getMonth().getValue() <=
			 * Month.APRIL.getValue()) {
			 * 
			 * if (startDate.getMonth().getValue() == Month.JANUARY.getValue()) {
			 * 
			 * logger.info("startDate " + startDate + " endDate " + endDate +
			 * " year>1 and month<April,quarterly in"); // durationDetails = new
			 * DurationDetails();
			 * 
			 * // durationDetails.setStartDate(startDate.toString());
			 * 
			 * String quarterlyString = startDate.getYear() + "_Q04";
			 * 
			 * finalResponse = finalResponse.concat(quarterlyString).concat(",");
			 * 
			 * startDate = LocalDate.of(startDate.getYear(), Month.MARCH,
			 * Month.MARCH.maxLength());
			 * 
			 * if (endDate.isBefore(startDate)) startDate = endDate;
			 * 
			 * // durationDetails.setEndDate(startDate.toString());
			 * 
			 * 
			 * quarterlyDurations.add(breakUpDetails);
			 * responseModel.getQuarterlyBreakupDetails().setNoOfQuaterlyBreakUps(++
			 * quarterlyBreakUp);
			 * responseModel.getQuarterlyBreakupDetails().setListOfDurations(
			 * quarterlyDurations);
			 * 
			 * startDate = startDate.plusDays(1);
			 * 
			 * period = Period.between(startDate, endDate); logger.info("startDate " +
			 * startDate + " endDate " + endDate + " year>1 and month<April,quarterly out");
			 * } else {
			 * 
			 * for (; startDate.getMonth().getValue() <= Month.MARCH.getValue();) {
			 * 
			 * // durationDetails = new DurationDetails();
			 * 
			 * // durationDetails.setStartDate(startDate.toString());
			 * logger.info("startDate " + startDate + " endDate " + endDate +
			 * " year>1 and month<April,monthly in");
			 * 
			 * String monthlyString = startDate.getYear() + "_M0" +
			 * startDate.getMonthValue();
			 * 
			 * finalResponse = finalResponse.concat(monthlyString).concat(",");
			 * 
			 * 
			 * int daysOfMonth = 0; if (startDate.getMonth().getValue() ==
			 * Month.FEBRUARY.getValue() && startDate.isLeapYear()) {
			 * 
			 * daysOfMonth = startDate.getMonth().maxLength(); } else if
			 * (startDate.getMonth().getValue() == Month.FEBRUARY.getValue()) {
			 * 
			 * daysOfMonth = startDate.getMonth().maxLength() - 1; } else { daysOfMonth =
			 * startDate.getMonth().maxLength(); }
			 * 
			 * startDate = LocalDate.of(startDate.getYear(), startDate.getMonth(),
			 * daysOfMonth);
			 * 
			 * if (endDate.isBefore(startDate)) startDate = endDate; //
			 * durationDetails.setEndDate(startDate.toString());
			 * 
			 * 
			 * monthlyDurations.add(breakUpDetails);
			 * responseModel.getMonthlyBreakUpDetails().setNoOfMonthlyBreakUp(++
			 * monthlyBreakUp);
			 * responseModel.getMonthlyBreakUpDetails().setListOfDurations(monthlyDurations)
			 * ;
			 * 
			 * startDate = startDate.plusDays(1);
			 * 
			 * period = Period.between(startDate, endDate); logger.info("startDate " +
			 * startDate + " endDate " + endDate + " year>1 and month<April,monthly out");
			 * 
			 * }
			 * 
			 * } } else {
			 * 
			 * LocalDate nextFinancialYear = LocalDate.of(startDate.plusYears(1).getYear(),
			 * Month.MARCH, Month.MARCH.maxLength());
			 * 
			 * for (; startDate.isBefore(nextFinancialYear);) {
			 * 
			 * if (startDate.getMonth().firstMonthOfQuarter() == startDate.getMonth()) {
			 * 
			 * // durationDetails = new DurationDetails();
			 * 
			 * // durationDetails.setStartDate(startDate.toString());
			 * 
			 * logger.info("startDate " + startDate + " endDate " + endDate +
			 * "yearly>1 and month>apr,quarterly in"); String quarterlyString = null; if
			 * (startDate.getMonth() == Month.APRIL) { quarterlyString = startDate.getYear()
			 * + "_Q01"; } else if (startDate.getMonth() == Month.JULY) { quarterlyString =
			 * startDate.getYear() + "_Q02"; } else if (startDate.getMonth() ==
			 * Month.OCTOBER) { quarterlyString = startDate.getYear() + "_Q03"; } else {
			 * quarterlyString = startDate.getYear() + "_Q04"; }
			 * 
			 * finalResponse = finalResponse.concat(quarterlyString).concat(",");
			 * 
			 * startDate = LocalDate.of(startDate.getYear(),
			 * startDate.plusMonths(2).getMonth(),
			 * startDate.plusMonths(2).getMonth().maxLength());
			 * 
			 * if (endDate.isBefore(startDate)) startDate = endDate; //
			 * durationDetails.setEndDate(startDate.toString());
			 * 
			 * 
			 * 
			 * quarterlyDurations.add(breakUpDetails);
			 * responseModel.getQuarterlyBreakupDetails().setNoOfQuaterlyBreakUps(++
			 * quarterlyBreakUp);
			 * responseModel.getQuarterlyBreakupDetails().setListOfDurations(
			 * quarterlyDurations);
			 * 
			 * startDate = startDate.plusDays(1);
			 * 
			 * period = Period.between(startDate, endDate);
			 * 
			 * logger.info("startDate " + startDate + " endDate " + endDate +
			 * "yearly>1 and month>apr,quarterly out");
			 * 
			 * } else {
			 * 
			 * // durationDetails = new DurationDetails();
			 * 
			 * // durationDetails.setStartDate(startDate.toString());
			 * 
			 * logger.info("startDate " + startDate + " endDate " + endDate +
			 * "yearly>1 and month>apr,monthly in"); String monthlyString ="";
			 * if(startDate.getMonthValue()<10){
			 * 
			 * monthlyString = startDate.getYear() + "_M0" + startDate.getMonthValue();
			 * }else {
			 * 
			 * monthlyString = startDate.getYear() + "_M" + startDate.getMonthValue(); }
			 * 
			 * finalResponse = finalResponse.concat(monthlyString).concat(",");
			 * 
			 * 
			 * 
			 * int daysOfMonth = 0; if (startDate.getMonth().getValue() ==
			 * Month.FEBRUARY.getValue() && startDate.isLeapYear()) {
			 * 
			 * daysOfMonth = startDate.getMonth().maxLength(); } else if
			 * (startDate.getMonth().getValue() == Month.FEBRUARY.getValue()) {
			 * 
			 * daysOfMonth = startDate.getMonth().maxLength() - 1; } else { daysOfMonth =
			 * startDate.getMonth().maxLength(); } startDate =
			 * LocalDate.of(startDate.getYear(), startDate.getMonth(), daysOfMonth);
			 * 
			 * if (endDate.isBefore(startDate)) startDate = endDate; //
			 * durationDetails.setEndDate(startDate.toString());
			 * 
			 * 
			 * monthlyDurations.add(breakUpDetails);
			 * responseModel.getMonthlyBreakUpDetails().setNoOfMonthlyBreakUp(++
			 * monthlyBreakUp);
			 * responseModel.getMonthlyBreakUpDetails().setListOfDurations(monthlyDurations)
			 * ;
			 * 
			 * startDate = startDate.plusDays(1);
			 * 
			 * period = Period.between(startDate, endDate); logger.info("startDate " +
			 * startDate + " endDate " + endDate + "yearly>1 and month>apr,monthly out"); }
			 * }
			 * 
			 * } } else if (period.getMonths() >= 0 || period.getDays() >= 0) {
			 * 
			 * if (startDate.getMonth().firstMonthOfQuarter() == startDate.getMonth() &&
			 * period.getMonths() > 2) {
			 * 
			 * // durationDetails = new DurationDetails();
			 * 
			 * // durationDetails.setStartDate(startDate.toString());
			 * logger.info("startDate " + startDate + " endDate " + endDate +
			 * "yearly<1 and quarterly in"); String quarterlyString = null; if
			 * (startDate.getMonth() == Month.APRIL) { quarterlyString = startDate.getYear()
			 * + "_Q01"; } else if (startDate.getMonth() == Month.JULY) { quarterlyString =
			 * startDate.getYear() + "_Q02"; } else if (startDate.getMonth() ==
			 * Month.OCTOBER) { quarterlyString = startDate.getYear() + "_Q03"; } else {
			 * quarterlyString = startDate.getYear() + "_Q04"; }
			 * 
			 * finalResponse = finalResponse.concat(quarterlyString).concat(",");
			 * 
			 * startDate = LocalDate.of(startDate.getYear(),
			 * startDate.plusMonths(2).getMonth(),
			 * startDate.plusMonths(2).getMonth().maxLength());
			 * 
			 * if (endDate.isBefore(startDate)) startDate = endDate; //
			 * durationDetails.setEndDate(startDate.toString());
			 * 
			 * 
			 * quarterlyDurations.add(breakUpDetails);
			 * responseModel.getQuarterlyBreakupDetails().setNoOfQuaterlyBreakUps(++
			 * quarterlyBreakUp);
			 * responseModel.getQuarterlyBreakupDetails().setListOfDurations(
			 * quarterlyDurations);
			 * 
			 * startDate = startDate.plusDays(1);
			 * 
			 * period = Period.between(startDate, endDate); logger.info("startDate " +
			 * startDate + " endDate " + endDate + "yearly<1 and quarterly out");
			 * 
			 * } else {
			 * 
			 * // durationDetails = new DurationDetails();
			 * 
			 * // durationDetails.setStartDate(startDate.toString());
			 * logger.info("startDate " + startDate + " endDate " + endDate +
			 * "yearly<1 and monthly in"); String monthlyString = "";
			 * if(startDate.getMonthValue()<10){
			 * 
			 * monthlyString = startDate.getYear() + "_M0" + startDate.getMonthValue();
			 * }else {
			 * 
			 * monthlyString = startDate.getYear() + "_M" + startDate.getMonthValue(); }
			 * 
			 * finalResponse = finalResponse.concat(monthlyString).concat(",");
			 * 
			 * int daysOfMonth = 0; if (startDate.getMonth().getValue() ==
			 * Month.FEBRUARY.getValue() && startDate.isLeapYear()) {
			 * 
			 * daysOfMonth = startDate.getMonth().maxLength(); } else if
			 * (startDate.getMonth().getValue() == Month.FEBRUARY.getValue()) {
			 * 
			 * daysOfMonth = startDate.getMonth().maxLength() - 1; } else { daysOfMonth =
			 * startDate.getMonth().maxLength(); } startDate =
			 * LocalDate.of(startDate.getYear(), startDate.getMonth(), daysOfMonth);
			 * 
			 * 
			 * if (endDate.isBefore(startDate)) startDate = endDate; //
			 * durationDetails.setEndDate(startDate.toString());
			 * 
			 * 
			 * monthlyDurations.add(breakUpDetails);
			 * responseModel.getMonthlyBreakUpDetails().setNoOfMonthlyBreakUp(++
			 * monthlyBreakUp);
			 * responseModel.getMonthlyBreakUpDetails().setListOfDurations(monthlyDurations)
			 * ;
			 * 
			 * startDate = startDate.plusDays(1);
			 * 
			 * period = Period.between(startDate, endDate); logger.info("startDate " +
			 * startDate + " endDate " + endDate + "yearly<1 and monthly out");
			 * 
			 * }
			 * 
			 * }
			 * 
			 */}
		/*
		 * ObjectMapper objMapper = new ObjectMapper();
		 * 
		 * String response =
		 * objMapper.writerFor(ResponseModel.class).writeValueAsString(responseModel);
		 */

		if (finalResponse.endsWith(",")) {
			logger.info(finalResponse);
			finalResponse = finalResponse.substring(0, finalResponse.length() - 1);
			logger.info(finalResponse);
		}

		return finalResponse;
	}

}
