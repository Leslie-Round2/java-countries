package local.leslie.countries;

public class Country
{
	//a country name, population, land mass size, and median age

	//fields
	private String name;
	private long landsize;
	private long population;
	private int medianAge;

	public Country(String name, long landsize, long population, int medianAge)
	{
		this.name = name;
		this.landsize = landsize;
		this.population = population;
		this.medianAge = medianAge;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getLandsize()
	{
		return landsize;
	}

	public void setLandsize(long landsize)
	{
		this.landsize = landsize;
	}

	public long getPopulation()
	{
		return population;
	}

	public void setPopulation(long population)
	{
		this.population = population;
	}

	public int getMedianAge()
	{
		return medianAge;
	}

	public void setMedianAge(int medianAge)
	{
		this.medianAge = medianAge;
	}

	@Override
	public String toString()
	{
		return "Country{" + "name='" + name + '\'' + ", landsize=" + landsize + ", population=" + population + ", medianAge=" + medianAge + '}';
	}
}
