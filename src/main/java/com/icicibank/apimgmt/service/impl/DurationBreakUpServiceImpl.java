package com.icicibank.apimgmt.service.impl;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.icicibank.apimgmt.model.BreakUp;
import com.icicibank.apimgmt.model.DurationDetails;
import com.icicibank.apimgmt.model.ResponseModel;
import com.icicibank.apimgmt.service.DurationBreakUpService;

@Service
public class DurationBreakUpServiceImpl implements DurationBreakUpService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${date.format}")
	String dateFormat;

	@Autowired
	ResponseModel responseModel;

	@Autowired
	BreakUp breakUpDetails;

	@Override
	public ResponseModel getBreakUpDurations(DurationDetails duration) {

		int yearlyBreakUp = 0;
		int quarterlyBreakUp = 0;
		int monthlyBreakUp = 0;

		List<BreakUp> yearlyDurations = new ArrayList<>();

		List<BreakUp> monthlyDurations = new ArrayList<>();

		List<BreakUp> quarterlyDurations = new ArrayList<>();

		logger.info((dateFormat));
		LocalDate intialDate = LocalDate.parse(duration.getStartDate(), DateTimeFormatter.ofPattern(dateFormat));

		LocalDate endDate = LocalDate.parse(duration.getEndDate(), DateTimeFormatter.ofPattern(dateFormat));

		LocalDate startDate = intialDate;
		Period period = Period.between(startDate, endDate);

		logger.info("startDate " + startDate + " endDate " + endDate);

		while (startDate.isBefore(endDate)) {

			if (period.getYears() >= 1) {
				
				

				if (startDate.getMonth().getValue() == Month.APRIL.getValue()) {

					

					//durationDetails.setStartDate(startDate.toString());
					String yearlyStirng= startDate.getYear()+"_A01";

					breakUpDetails = new BreakUp(yearlyStirng);
					startDate = LocalDate.of(startDate.plusYears(1).getYear(), Month.MARCH, Month.MARCH.maxLength());

					if(endDate.isBefore(startDate))
						startDate = endDate;
					//durationDetails.setEndDate(startDate.toString());

					yearlyDurations.add(breakUpDetails);
					responseModel.getYearlyBreakupDetails().setNoOfYearlyBreakUps(++yearlyBreakUp);
					responseModel.getYearlyBreakupDetails().setListOfDurations(yearlyDurations);

					startDate = startDate.plusDays(1);

					
					period = Period.between(startDate, endDate);
				} else if (startDate.getMonth().getValue() <= Month.APRIL.getValue()) {

					if (startDate.getMonth().getValue() == Month.JANUARY.getValue()) {

						//durationDetails = new DurationDetails();

						//durationDetails.setStartDate(startDate.toString());

						String quarterlyString = startDate.getYear()+"_Q04";
						
						breakUpDetails = new BreakUp(quarterlyString);
						startDate = LocalDate.of(startDate.getYear(), Month.MARCH, Month.MARCH.maxLength());

						if(endDate.isBefore(startDate))
							startDate = endDate;
						
						
						//durationDetails.setEndDate(startDate.toString());

						quarterlyDurations.add(breakUpDetails);
						responseModel.getQuarterlyBreakupDetails().setNoOfQuaterlyBreakUps(++quarterlyBreakUp);
						responseModel.getQuarterlyBreakupDetails().setListOfDurations(quarterlyDurations);

						startDate = startDate.plusDays(1);
						
						

						period = Period.between(startDate, endDate);
					} else {

						for (; startDate.getMonth().getValue() <= Month.MARCH.getValue();) {
							
							//durationDetails = new DurationDetails();

							//durationDetails.setStartDate(startDate.toString());
							
							String monthlyString = startDate.getYear()+"_M0"+startDate.getMonthValue();
							
							breakUpDetails = new BreakUp(monthlyString);

							int daysOfMonth = 0;
							if (startDate.getMonth().getValue() == Month.FEBRUARY.getValue()
									&& startDate.isLeapYear()) {

								daysOfMonth = startDate.getMonth().maxLength();
							} else if (startDate.getMonth().getValue() == Month.FEBRUARY.getValue()) {

								daysOfMonth = startDate.getMonth().maxLength() - 1;
							} else {
								daysOfMonth = startDate.getMonth().maxLength();
							}

							startDate = LocalDate.of(startDate.getYear(), startDate.getMonth(), daysOfMonth);

							if(endDate.isBefore(startDate))
								startDate = endDate;
							//durationDetails.setEndDate(startDate.toString());

							monthlyDurations.add(breakUpDetails);
							responseModel.getMonthlyBreakUpDetails().setNoOfMonthlyBreakUp(++monthlyBreakUp);
							responseModel.getMonthlyBreakUpDetails().setListOfDurations(monthlyDurations);

							startDate = startDate.plusDays(1);
							
							
							period = Period.between(startDate, endDate);

						}

					}
				} else {

					LocalDate nextFinancialYear = LocalDate.of(startDate.plusYears(1).getYear(), Month.MARCH,
							Month.MARCH.maxLength());
					
					for(;startDate.isBefore(nextFinancialYear);) {
						
						if(startDate.getMonth().firstMonthOfQuarter()==startDate.getMonth()) {
							
							//durationDetails = new DurationDetails();

							//durationDetails.setStartDate(startDate.toString());
							String quarterlyString =null;
							if(startDate.getMonth()==Month.APRIL) {
								 quarterlyString = startDate.getYear()+"_Q01";
							}else if(startDate.getMonth()==Month.JULY) {
								 quarterlyString = startDate.getYear()+"_Q02";
							}else if(startDate.getMonth()==Month.OCTOBER) {
								 quarterlyString = startDate.getYear()+"_Q03";
							}else {
								 quarterlyString = startDate.getYear()+"_Q04";
							}
							
							breakUpDetails = new BreakUp(quarterlyString);
							startDate = LocalDate.of(startDate.getYear(), startDate.plusMonths(2).getMonth(), startDate.plusMonths(2).getMonth().maxLength());

							if(endDate.isBefore(startDate))
								startDate = endDate;
							//durationDetails.setEndDate(startDate.toString());

							quarterlyDurations.add(breakUpDetails);
							responseModel.getQuarterlyBreakupDetails().setNoOfQuaterlyBreakUps(++quarterlyBreakUp);
							responseModel.getQuarterlyBreakupDetails().setListOfDurations(quarterlyDurations);

							startDate = startDate.plusDays(1);
							
							

							period = Period.between(startDate, endDate);
							
							
						}else {
							
							//durationDetails = new DurationDetails();

							//durationDetails.setStartDate(startDate.toString());

							String monthlyString = startDate.getYear()+"_M0"+startDate.getMonthValue();
							breakUpDetails = new BreakUp(monthlyString);
							startDate = LocalDate.of(startDate.getYear(), startDate.getMonth(),startDate.getMonth().maxLength());

							if(endDate.isBefore(startDate))
								startDate = endDate;
							//durationDetails.setEndDate(startDate.toString());

							monthlyDurations.add(breakUpDetails);
							responseModel.getMonthlyBreakUpDetails().setNoOfMonthlyBreakUp(++monthlyBreakUp);
							responseModel.getMonthlyBreakUpDetails().setListOfDurations(monthlyDurations);

							startDate = startDate.plusDays(1);
							
							

							period = Period.between(startDate, endDate);
						}
					}

				}
			}else if(0>=period.getYears() && period.getMonths()>=0 || period.getDays()>=1){
				if(startDate.getMonth().firstMonthOfQuarter()==startDate.getMonth()) {
					

					
					//durationDetails = new DurationDetails();

					//durationDetails.setStartDate(startDate.toString());
					
					String quarterlyString =null;
					if(startDate.getMonth()==Month.APRIL) {
						 quarterlyString = startDate.getYear()+"_Q01";
					}else if(startDate.getMonth()==Month.JULY) {
						 quarterlyString = startDate.getYear()+"_Q02";
					}else if(startDate.getMonth()==Month.OCTOBER) {
						 quarterlyString = startDate.getYear()+"_Q03";
					}else {
						 quarterlyString = startDate.getYear()+"_Q04";
					}

					breakUpDetails = new BreakUp(quarterlyString);
					startDate = LocalDate.of(startDate.getYear(), startDate.plusMonths(2).getMonth(), startDate.plusMonths(2).getMonth().maxLength());

					if(endDate.isBefore(startDate))
						startDate = endDate;
					//durationDetails.setEndDate(startDate.toString());

					quarterlyDurations.add(breakUpDetails);
					responseModel.getQuarterlyBreakupDetails().setNoOfQuaterlyBreakUps(++quarterlyBreakUp);
					responseModel.getQuarterlyBreakupDetails().setListOfDurations(quarterlyDurations);

					startDate = startDate.plusDays(1);
					
					

					period = Period.between(startDate, endDate);
					
				}else {

					
					//durationDetails = new DurationDetails();

					//durationDetails.setStartDate(startDate.toString());
					
					String monthlyString = startDate.getYear()+"_M0"+startDate.getMonthValue();

					breakUpDetails = new BreakUp(monthlyString);
					startDate = LocalDate.of(startDate.getYear(), startDate.getMonth(),startDate.getMonth().maxLength());

					if(endDate.isBefore(startDate))
						startDate = endDate;
					//durationDetails.setEndDate(startDate.toString());

					monthlyDurations.add(breakUpDetails);
					responseModel.getMonthlyBreakUpDetails().setNoOfMonthlyBreakUp(++monthlyBreakUp);
					responseModel.getMonthlyBreakUpDetails().setListOfDurations(monthlyDurations);

					startDate = startDate.plusDays(1);

					period = Period.between(startDate, endDate);
				
					
				}
				
			}

		}

		return responseModel;
	}

}
