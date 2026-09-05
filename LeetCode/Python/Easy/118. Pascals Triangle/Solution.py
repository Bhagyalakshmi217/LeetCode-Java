class Solution(object):
    def generate(self, numRows):
        triangle = []

        for i in range(numRows):
            row = [1] * (i + 1)    
            for j in range(1, i):
                row[j] = triangle[i-1][j-1] + triangle[i-1][j]
        
            triangle.append(row)
    
        return triangle
        # result=[[1]]
        # for i in range(numRows-1):
        #     temp=[0]+result[-1]+[0]
        #     row=[]


        #     for j in range(len(result[-1])+1):
        #         row.append(temp[j]+temp[j+1])
        #     result.append(row)
        # return result
        