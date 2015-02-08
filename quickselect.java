public int QuickSlect(int[] G, int k)
{
	return helper(G, 0, G.length-1, k-1);
}

public int helper(int[] G, int s, int e, int k)
{
	if(s<=e)
	{
		int pivot = partition(G, s, e);
		if(k == pivot)
			return G[pivot];
		else if(k>pivot)
			return helper(G, pivot+1, e, k);
		else
			return helper(G, s, pivot-1, k);
	}
	throw new NullPointerException();
	return Integer.MIN_VALUE;
}


public int partition(int[] g, int s, int e)
{
	// nextInt is from 0 to the other but the other is not included
	int pivot = s + new Random.nextInt(e-s+1);
	swap(g, pivot, e);
	int val = g[e];
	int first = s;
	for(int i=s; i<e; i++)
	{
		if(g[i]<val)
			swap(g, i, first++);
	}
	swap(g, first, e);
	return first;

}

public void swap(int[] g, int a, int b)
{
	int temp = g[a];
	g[a] = g[b];
	g[b] = temp;
	return;
}