# Ride the (REAL) trendy wave!!

[The platform is live here](https://socialnewsverifier.herokuapp.com/)
* Log in using Facebook
* Subscribe to News Sources
* Vote on and track news stories 

[Test out our Bayesian Classifier endpoint](https://classifierrest.herokuapp.com/predict/There%20have%20been%20deadly%20riots%20in%20India%20today)

Some calls available:
* **/predict/[String to Verify]** : Get real time classification
* **/evaluate** : Get evaluation metrics for our Bayesian classifier
## OVERVIEW
We are proposing to create a new crowdsourced news verification platform which will serve the following purposes:
* Create shareable content by aggregating the various trending news stories by breaking down the news according to sources.
* Provide the user with tools necessary to make an informed vote.
* Use Crowdsourcing way to sift out popular news.
* Track the usage of the users and reward them accordingly. 
* Boost the authentication of various trends by using a machine learning algorithm.
* Provide credibility ratings for various news organizations based on the verification feedback loop. 
* Crowdsource the verification of stories to users and allow for a credibility index for each user.  

## IMPLEMENTATION 

**1. Data Analysis for Automatic verification using WEKA ML library:**

a)Training and Evaluation 

We have looked for a few datasets to train our veracity analysis model which would be based on the Weka Machine Learning package.
We are using 2 following data sets for building our veracity analysis algorithm:
* Fake News: Around 60k fake texts and articles. (Courtesy: Kaggle) 
* Real News: Around 3k real news articles collected from various sources. (Courtesy: Several public News sources)

We are using the very popular Weka Machine Learning library for our purpose. 

We have looked at various text analysis methods including n-gram tokenizers. In terms of classification methods, we looked at the id3 Decision Tree vs Bayesian model for our classifier. 

We have used Bayesian Multinomial Classifier for the project as it can seamlessly be used to make real-time predictions for textual data.

We have deployed our trained model to Heroku and we are providing a live API for easy and quick text-based veracity classification. The RESTful API is available and the usage is as simple as issuing a GET request.

**Example:** 

To verify a text : “There have been deadly riots in India today” :  
https://classifierrest.herokuapp.com/predict/There%20have%20been%20deadly%20riots%20in%20India%20today 

The above returns Fake as the label. Similarly, we can use the above for quick verification of text. 

**2. Crowdsourcing the entire exercise**

There are several issues with “human - intervention less” methods to news verification.
Context-less data analysis tools do not provide desired accuracy in News verification.
Once in a lifetime real news mostly gets classified as fake. (Ex: Death of a celebrity, Future alien encounters etc!)
Therefore, we are proposing a mix of the 2 worlds. A crowdsourced social-media based news verification platform that seamlessly integrates with our data-analysis tools to provide a complete picture. 
  
We have achieved this integration using Ruby on Rails framework and PostgreSQL database with appropriate attention to usability as well as efficacy. 

The website is live here :  https://socialnewsverifier.herokuapp.com/ 

A user has the option to vote for any news article on his feed that hasn’t been closed for voting yet. The feed consists only of unverified open stories that need his vote. A user can choose to vote on any article of his choice.
Once he opts to vote for an article, we provide him the below tools to make an informed decision:

1. Bayesian Prediction from our algorithm
2. Current Voting trends
3. Reverse Google image search capability from our application
4. Authors, Source, Date of publication of the news and other contextual information
Based on the above information at hand and his own judgement, the user can choose to either cast his vote for the article as Real or Fake. He can abstain from voting as well!

**Other tools at hand for the user:**

We provide several other views for the user of our application. Some of the features we have provided are:
1. Customized feed for articles the user voted as Fake.
2. Customized feed for articles the user voted as Real.
3. Feed for news articles that have been verified Real by our Verifier application.
4.Feed for news articles that have been verified Real by our Verifier application.
5. Browse through the different sources of our applications and view their Credibility history. Ex: The credibility score of a news organization like CNN vs feed from Reddit.
6. Subscribe/Unsubscribe to sources.
7. Tags/Categories for the news article.
8. View user leaderboards based on credibility score.
9. View his/her own credibility/usage score and trade points towards credibility score.
etc...

## Voting Methodology

We propose the an aggregated voting methodology with a feedback loop for our verification process. 
Below is a simple flow involving a single user and a single article:

1. Every new user starts with a credibility score of 100.
2. He goes to a news articles and casts his votes as Real/Fake
3. The application freezes voting after a fixed period of time or admin has the capability to do so.
4. The veracity score for the article is calculated as below:
     a) For every upvote, truth score is incremented by the credibility score of the user who cast the vote.
     b) For every downvote, fake score is incremented by the credibility score of user who cast the vote.
     c) We add 30% weightage to our Bayesian Prediction and increment the upvote/downvote accordingly.
     d) The credibility score of source of the article gets a 20% weight in the algorithm. 
     d) A simple percentage calculation from here gives us the veracity percentage for the article

This can be thought of as a credible user being able to cast more ballots in a election. It can also be thought of as a weighted voting process. Also, a source is rewarded for consistently maintaining a high credibility score. This works as reputation of the source. The credibility of user and reputation of source are incrementally calculated by our feedback loop.
Feedback Loop
For every article that our application has classified as Real/Fake, we run a feedback loop for the users as well as the source.
For the user:
1) We add a bonus unit to the credibility score for the user who classified in accordance with the final result.
2) We apply a sanction unit to users who classified real news as fake.
3) We apply 2 sanction units to users who classified fake news as real.
For the Source of the article:
1) The total number of upvotes of the article are added to reputation score of the source.
2) The total number of downvotes of the article are deducted from reputation score of the source.
3) The score is normalized to 100 to get reputation score of the source.
Over a period of time the credibility score and reputation of the sources develop into accurate pointers for our algorithm and the voting results get more and more accurate. 

## HYPOTHESES
__“Machine learning cannot solve the menace of Fake News efficiently without human intervention!”__

We present the following reasons in support:
* Our classifier results presented above highlight that text-based trained models do not achieve high accuracy in classification.
* There is a lack of data as far as fake news is concerned. The data source we used was comprised of biases, opinions, fake.
* Multilingual sources of information exist for news stories today. However, supervised learning cannot be performed on such data as labeled data is not readily available.
* An approach which picks the best of both worlds is the best approach to fight the menace of fake news!   

## Future Scope for improvements
There are several areas of improvement to the implementation of ours.

a) Create a feedback loop for the Bayesian Model and calculate the weight of the automated predictor.

b) Create a loop from the gathered data from our application to retrain the model. We see an advantage in this front because our application generates data is multiple languages including sources in Hindi, Urdu, Mandarin etc. Such data is scarcely available publicly.

c) There is scope to extend this crowdsourcing method with support for specialists of particular domains etc. The specialists could come in handy as a single source of truth in their domain of expertise.  

        
 


 
